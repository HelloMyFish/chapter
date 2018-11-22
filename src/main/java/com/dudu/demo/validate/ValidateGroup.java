package com.dudu.demo.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/3123:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public  @interface ValidateGroup {
    public ValidateFiled[] fileds() ;
}
