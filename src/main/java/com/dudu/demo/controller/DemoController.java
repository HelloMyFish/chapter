package com.dudu.demo.controller;

import com.dudu.demo.common.annotation.SystemLogAnnotation;
import com.dudu.demo.constant.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @SystemLogAnnotation(value = "这是demo接口")
    public Map<String, Object> start(@RequestParam String name) {
        Map<String, Object> result = new HashMap<>(16);
        if ("".equals(name)) {
            result.put("error", ErrorMessage.PARAMS_EMPTY.getEnglishMsg());
            result.put("error_message", ErrorMessage.PARAMS_EMPTY.getChineseMsg());
            result.put("error", "params_empty");
            result.put("error_message", "参数为空");
            return result;
        }
        result.put("error", "查询成功");
        return result;
    }
}
