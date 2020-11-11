package com.itcorey.vo;

import com.itcorey.entity.Comment;
import lombok.Data;

/**
 * @Auther: corey
 * @Date: 2020/11/11 10:34
 * @Description: 文章操作信息
 */
@Data
public class CommentVo extends Comment {

    private Long authorId;
    private String authorName;
    private String authorAvatar;
}
