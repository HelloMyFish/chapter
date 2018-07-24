package com.dudu.demo.controller;

import com.dudu.demo.common.annotation.SystemLogAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2421:08
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping(value = "")
    @ResponseBody
    @SystemLogAnnotation(value="这是demo接口")
    public String start(){
        return "demo";
    }
}
