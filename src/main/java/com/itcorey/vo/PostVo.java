package com.itcorey.vo;

import com.itcorey.entity.Post;
import lombok.Data;

/**
 * @Auther: corey
 * @Date: 2020/11/10 16:23
 * @Description:
 */
@Data
public class PostVo extends Post {

    private Long authorId;
    private String authorName;
    private String authorAvatar;
    private String categoryName;

}
