/*
 *   编写日期：2022/6/8 11:53
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.utils;

public final class Print {
    /**
     * @param obj 要打印的文本
     */
    public static void out(Object obj) {
        out("%s", obj);
    }

    /**
     * @param format 格式化，如%s %d
     * @param obj    要打印的文本
     */
    public static void out(String format, Object... obj) {
        Object[] params = new Object[obj.length];
        int k = 0;
        for (Object r : obj) {
            params[k++] = r;
        }
        System.out.printf(format, obj).println();
    }
}
