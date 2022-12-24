/*
 *   编写日期：2022/6/10 14:37
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.utils;

import java.util.UUID;

public final class Guid {
    /**
     * @return guid
     */
    public static String randomId() {
        return uuid().toString();
    }

    /**
     * @return guid对象
     */
    public static UUID uuid() {
        return UUID.randomUUID();
    }
}
