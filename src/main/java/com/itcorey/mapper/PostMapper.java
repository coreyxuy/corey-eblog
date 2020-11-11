package com.itcorey.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itcorey.vo.PostVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 公众号：徐买狼
 * @since 2020-11-10
 */
public interface PostMapper extends BaseMapper<Post> {

    IPage<PostVo> selectPosts(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);

    //查询文章详情
    PostVo selectOnePosts(@Param(Constants.WRAPPER) QueryWrapper<Post> wrapper);
}
