package com.itcorey.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itcorey.vo.PostVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
public interface PostService extends IService<Post> {

    IPage<PostVo> paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    PostVo selectOnePost(QueryWrapper<Post> wrapper);
}
