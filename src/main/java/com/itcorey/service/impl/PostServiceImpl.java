package com.itcorey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.entity.Post;
import com.itcorey.mapper.PostMapper;
import com.itcorey.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcorey.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Resource
    PostMapper postMapper;

    @Override
    public IPage<PostVo>paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order) {
        if(level == null) level = -1;
        QueryWrapper wrapper = new QueryWrapper<Post>()
                .eq(categoryId != null,  "category_id", categoryId)
                .eq(userId != null,  "user_id", userId)
                .eq(level == 0,  "level", 0)
                .gt(level > 0,  "level", 0)
                .orderByDesc(order != null, order);
        IPage<PostVo> postVoIPage = postMapper.selectPosts(page, wrapper);
        return postVoIPage;
    }

    @Override
    public PostVo selectOnePost(QueryWrapper<Post> wrapper) {
        return postMapper.selectOnePosts(wrapper);
    }
}
