package com.itcorey.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itcorey.entity.Post;
import com.itcorey.service.PostService;
import com.itcorey.utils.RedisUtil;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Auther: corey
 * @Date: 2020/11/12 16:34
 * @Description: 定时刷新
 */
@Component
public class viewCountSyncTask {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    PostService postService;


    @Scheduled(cron = "0 0/1 * * * *") //每分钟同步
    public void task() {
        Set<String> keys = redisTemplate.keys("rank:post:*");

        List<String> ids = new ArrayList<>();
        for (String key : keys) {
            if (redisUtil.hHasKey(key, "post:key")) {
                ids.add(key.substring("rank:post".length()));
            }
        }
        if (ids.isEmpty()) return;
        //需要更新阅读量
        List<Post> posts = postService.list(new QueryWrapper<Post>().in("id", ids));

        posts.stream().forEach((post) -> {
            Integer viewCount = (Integer) redisUtil.hget("rank:post" + post.getId(), "post:viewCount");
            post.setViewCount(viewCount);
        });
        if (posts.isEmpty()) return;

        boolean isSucc = postService.updateBatchById(posts);
        if (isSucc) {
            ids.stream().forEach((id) -> {
                redisUtil.hdel("rank:post:" + id, "post:viewCount");
                System.out.println(id + "------------>同步成功！");
            });
        }
    }
}
