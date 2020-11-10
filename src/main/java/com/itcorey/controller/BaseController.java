package com.itcorey.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: corey
 * @Date: 2020/11/10 10:16
 * @Description:
 */
public class BaseController {

    @Autowired
    HttpServletRequest req;
}
