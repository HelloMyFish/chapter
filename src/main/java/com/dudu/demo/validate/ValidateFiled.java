package com.dudu.demo.validate;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/3123:16
 */
public @interface ValidateFiled {
    /**
     * 参数索引位置
     */
    public int index() default -1 ;

    /**
     * 如果参数是基本数据类型或String ，就不用指定该参数，如果参数是对象，要验证对象里面某个属性，就用该参数指定属性名
     */
    public String filedName() default "" ;

    /**
     * 正则验证
     */
    public String regStr() default "";

    /**
     * 是否能为空  ， 为true表示不能为空 ， false表示能够为空
     */
    public boolean notNull() default false;

    /**
     * 是否能为空  ， 为true表示不能为空 ， false表示能够为空
     */
    public int maxLen() default -1 ;

    /**
     * 最小长度 ， 用户验证字符串
     */
    public int minLen() default -1 ;

    /**
     *最大值 ，用于验证数字类型数据
     */
    public int maxVal() default -1 ;

    /**
     *最小值 ，用于验证数值类型数据
     */
    public int minVal() default -1 ;
    /**
     * 合法值 判断
     */
    public String legalValue() default "";
}
