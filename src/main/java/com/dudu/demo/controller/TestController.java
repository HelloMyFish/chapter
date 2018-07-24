package com.dudu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2420:56
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "")
    @ResponseBody
    public String start(){
        return "start";
    }
}
