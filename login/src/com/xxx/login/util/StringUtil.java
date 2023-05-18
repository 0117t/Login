package com.xxx.login.util;

/**
 * 字符串工具类
 *
 */

public class StringUtil {
    /**
     * 判断字符串是否为空
     *   如果为空，返回true
     *   如果不为空，则返回false
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }
}
