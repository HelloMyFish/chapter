package com.dudu.demo.constant;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2522:31
 */
public enum ErrorMessage {
    PARAMS_EMPTY("params_empty", "参数为空"),
    SELECT_FAIL("select_fail","查询失败");
    private String chineseMsg;
    private String englishMsg;

    private ErrorMessage(String chineseMsg, String englishMsg) {
        this.chineseMsg = chineseMsg;
        this.englishMsg = englishMsg;
    }

    public String getChineseMsg() {
        return this.chineseMsg;
    }

    public String getEnglishMsg() {
        return this.englishMsg;
    }
}
