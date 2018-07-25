package com.dudu.demo.service.Impl;

import com.dudu.demo.constant.ErrorMessage;
import com.dudu.demo.dao.StudentDao;
import com.dudu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2422:17
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Map<String, Object> getAllStu() {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> stuList = studentDao.getAllStu();
        if (stuList != null && stuList.size() != 0) {
            result.put("data", stuList);
            result.put("error", "");
        } else {
            result.put("data", "");
            result.put("error", "");
        }
        return result;
    }

    @Override
    public Map<String, Object> getStuById(String stuId) {
        Map<String, Object> result = new HashMap<>();
//        try {
            result = studentDao.getStuById(stuId);
//        } catch (Exception e) {
//            result.put("error", ErrorMessage.SELECT_FAIL.getEnglishMsg());
//            result.put("error_message", ErrorMessage.SELECT_FAIL.getChineseMsg());
//            return result;
//        }
        return result;
    }
}
