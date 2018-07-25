package com.dudu.demo.service;

import java.util.List;
import java.util.Map;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2422:17
 */
public interface StudentService {
    Map<String,Object> getAllStu();
    /** 根据学生id获取学生 **/
    Map<String,Object> getStuById(String stuId);
}
