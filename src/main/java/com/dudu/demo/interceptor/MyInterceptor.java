package com.dudu.demo.interceptor;

import com.dudu.demo.common.annotation.SystemLogAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2420:59
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("---根据注解，打印日志----");
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        SystemLogAnnotation systemLogAnnotation = method.getAnnotation(SystemLogAnnotation.class);
        if(systemLogAnnotation==null){
            return true;
        }else{
            String value = systemLogAnnotation.value();
            logger.info(value);
            return true;
        }
//        logger.info("preHandle被调用");
//        boolean flag = true;
//        String name = (String)request.getParameter("name");
//        if(name==null || name.equals("")){
//            logger.info("name不允许为空");
//            flag = false;
//            return flag;
//        }else {
//            return flag;
//        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 调用");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion调用");
    }
}
