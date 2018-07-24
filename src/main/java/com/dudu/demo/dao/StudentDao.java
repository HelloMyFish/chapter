package com.dudu.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2422:19
 */
@Mapper
public interface StudentDao {
    List<Map<String,Object>> getAllStu();
}
