package com.itcorey.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itcorey.entity.Category;
import com.itcorey.service.CategoryService;
import com.itcorey.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @Auther: corey
 * @Date: 2020/9/7 18:01
 * @Description: 启动加载类
 */
@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    @Autowired
    CategoryService categoryService;

    ServletContext servletContext;

    @Autowired
    PostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Category> categories = categoryService.list(new QueryWrapper<Category>()
                .eq("status", 0)
        );
        servletContext.setAttribute("categorys", categories);
        postService.initWeekRank();
        System.out.println("redis server started...");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

