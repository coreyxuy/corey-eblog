package com.itcorey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.entity.Comment;
import com.itcorey.mapper.CommentMapper;
import com.itcorey.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itcorey.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public IPage<CommentVo> paing(Page page, Long postId, Long userId, String order) {
        return commentMapper.selectComments(page, new QueryWrapper<Comment>()
                .eq(postId != null, "post_id", postId)
                .eq(userId != null, "user_id", userId)
                .orderByDesc(order != null, order)
        );
    }
}
