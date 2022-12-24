/*
 *   编写日期：2022/6/8 11:49
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.utils;

public final class StringUtils {

    /**
     * @param cs 任意字符
     * @return 指定字符串是否为null或者空串
     */
    public static boolean isEmptyOrNull(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
