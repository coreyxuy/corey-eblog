package com.itcorey.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itcorey.vo.CommentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
public interface CommentService extends IService<Comment> {

    /**
     * 查询文章具体信息
     * @param page
     * @param postId
     * @param userId
     * @param order
     * @return
     */
    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);
}
