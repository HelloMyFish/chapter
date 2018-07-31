package com.dudu.demo.controller;

import com.dudu.demo.common.annotation.SystemLogAnnotation;
import com.dudu.demo.constant.ErrorMessage;
import com.dudu.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value = "/stu")
public class StudentController {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @SystemLogAnnotation(value = "获取学生接口")
    public Map<String,Object> getStu(){
        logger.info("----getStu()接口------");
        Map<String,Object> result = studentService.getAllStu();
        logger.info("-----end-----");
        return result;
    }
    @RequestMapping(value = "/get-stu-by-id/{id}",method = RequestMethod.GET)
    @SystemLogAnnotation(value = "根据学生id查询学生信息")
    public Map<String,Object> getStuById(@PathVariable(value = "id")String stuId){
        Map<String,Object> result = new HashMap<>();
        if(stuId==null ||stuId.equals("")){
            result.put("error", ErrorMessage.PARAMS_EMPTY.getEnglishMsg());
            result.put("error_message", ErrorMessage.PARAMS_EMPTY.getChineseMsg());
            return result;
        }
        logger.info("stuId="+stuId);
        result = studentService.getStuById(stuId);
        return result;
    }
}
