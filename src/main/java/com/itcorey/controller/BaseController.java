package com.itcorey.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itcorey.service.CommentService;
import com.itcorey.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: corey
 * @Date: 2020/11/10 10:16
 * @Description:
 */
public class BaseController {

    @Autowired
    HttpServletRequest req;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;


    /**
     * 公共类分页抽取
     * @return
     */
    public Page getPage(){
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 2);
        return new Page(pn,size);
    }

}
