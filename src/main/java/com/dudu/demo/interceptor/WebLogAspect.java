package com.dudu.demo.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2522:15
 */
@Component
@Aspect
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.dudu.demo.controller..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("----打印前置通知----");
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL:" + request.getRequestURI().toString());
        logger.info("HTTP_METHOD:" + request.getMethod());
        logger.info("IP:" + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
//            logger.info("name:{},value:{}", name, request.getParameter(name));
            logger.info("ARGS:"+name+"="+ request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.info("----打印后置通知----");
        logger.info("RESPONSE :" + ret);
        logger.info("耗时:" + (System.currentTimeMillis() - startTime.get())+"毫秒");
    }

}
