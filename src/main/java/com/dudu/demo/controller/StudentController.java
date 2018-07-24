package com.dudu.demo.controller;

import com.dudu.demo.common.annotation.SystemLogAnnotation;
import com.dudu.demo.service.StudentService;
import javafx.scene.chart.ValueAxis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2422:15
 */
@RestController
@RequestMapping(value = "stu")
public class StudentController {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "get",method = RequestMethod.GET)
    @ResponseBody
    @SystemLogAnnotation(value = "获取学生接口")
    public Map<String,Object> getStu(){
        logger.info("----getStu()接口------");
        Map<String,Object> result = studentService.getAllStu();
        logger.info("-----end-----");
        return result;
    }
}
