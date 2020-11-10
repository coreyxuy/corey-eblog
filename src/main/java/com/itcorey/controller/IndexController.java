package com.itcorey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: corey
 * @Date: 2020/11/10 09:29
 * @Description:
 */
@Controller
public class IndexController {

    @RequestMapping({"/","","index"})
    public String index(){
        return "index";
    }
}