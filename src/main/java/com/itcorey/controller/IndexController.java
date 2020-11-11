package com.itcorey.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: corey
 * @Date: 2020/11/10 09:29
 * @Description:
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping({"", "/", "index"})
    public String index() {
        //1.分页信息 2.分类 3.用户 4.置顶 5.精选 6.排序
        IPage results = postService.paging(getPage(),null,null,null,null,"created");
        req.setAttribute("pageData", results);
        req.setAttribute("currentCategoryId", 0);
        return "index";
    }
}
