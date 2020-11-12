package com.itcorey.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.DatePrinter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.entity.Post;
import com.itcorey.mapper.PostMapper;
import com.itcorey.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcorey.utils.RedisUtil;
import com.itcorey.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Resource
    PostMapper postMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public IPage<PostVo> paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order) {
        if (level == null) level = -1;
        QueryWrapper wrapper = new QueryWrapper<Post>()
                .eq(categoryId != null, "category_id", categoryId)
                .eq(userId != null, "user_id", userId)
                .eq(level == 0, "level", 0)
                .gt(level > 0, "level", 0)
                .orderByDesc(order != null, order);
        IPage<PostVo> postVoIPage = postMapper.selectPosts(page, wrapper);
        return postVoIPage;
    }

    @Override
    public PostVo selectOnePost(QueryWrapper<Post> wrapper) {
        return postMapper.selectOnePosts(wrapper);
    }

    /**
     * 本周热议初始化
     */
    @Override
    public void initWeekRank() {

        // 获取7天的发表的文章
        List<Post> posts = this.list(new QueryWrapper<Post>()
                .ge("created", DateUtil.offsetDay(new Date(), -7)) // 11号
                .select("id, title, user_id, comment_count, view_count, created")
        );

        // 初始化文章的总评论量
        for (Post post : posts) {
            String key = "day:rank:" + DateUtil.format(post.getCreated(), DatePattern.PURE_DATE_FORMAT);

            redisUtil.zSet(key, post.getId(), post.getCommentCount());

            // 7天后自动过期(15号发表，7-（18-15）=4)
            long between = DateUtil.between(new Date(), post.getCreated(), DateUnit.DAY);
            long expireTime = (7 - between) * 24 * 60 * 60; // 有效时间

            redisUtil.expire(key, expireTime);

            // 缓存文章的一些基本信息（id，标题，评论数量，作者）
            this.hashCachePostIdAndTitle(post, expireTime);
        }

        // 做并集
        this.zunionAndStoreLast7DayForWeekRank();

    }

    /**
     * 本周合并每日评论数量操作
     */
    private void zunionAndStoreLast7DayForWeekRank() {
        String  currentKey = "day:rank:" + DateUtil.format(new Date(), DatePattern.PURE_DATE_FORMAT);

        String destKey = "week:rank";
        List<String> otherKeys = new ArrayList<>();
        for(int i=-6; i < 0; i++) {
            String temp = "day:rank:" +
                    DateUtil.format(DateUtil.offsetDay(new Date(), i), DatePattern.PURE_DATE_FORMAT);

            otherKeys.add(temp);
        }
        redisUtil.zUnionAndStore(currentKey, otherKeys, destKey);
    }


    /**
     * 缓存文章的基本信息
     * @param post
     * @param expireTime
     */
    private void hashCachePostIdAndTitle(Post post, long expireTime) {
        String key = "rank:post:" + post.getId();
        boolean hasKey = redisUtil.hasKey(key);
        if(!hasKey) {
            redisUtil.hset(key, "post:id", post.getId(), expireTime);
            redisUtil.hset(key, "post:title", post.getTitle(), expireTime);
            redisUtil.hset(key, "post:commentCount", post.getCommentCount(), expireTime);
            redisUtil.hset(key, "post:viewCount", post.getViewCount(), expireTime);
        }
    }
}
