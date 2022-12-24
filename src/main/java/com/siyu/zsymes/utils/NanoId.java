/*
 *   编写日期：2022/6/8 11:53
 *   作者：张赵
 *   说明：
 */

package com.siyu.zsymes.utils;

import java.security.SecureRandom;
import java.util.Random;

public class NanoId {
    private static final SecureRandom defaultNumberGenerator = new SecureRandom();
    private static final char[] defaultChar = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * @return 生成nanoid，21位
     */
    public static String randomId() {
        return randomId(defaultNumberGenerator, defaultChar, 21);
    }

    private static String randomId(Random random, char[] alphabet, int size) {
        if (random == null || alphabet == null) {
            throw new IllegalArgumentException("参数不能为空");
        } else if (alphabet.length != 0 && alphabet.length < 256) {
            if (size <= 0) {
                throw new IllegalArgumentException("位数必须大于0");
            } else {
                int mask = (2 << (int) Math.floor(Math.log((double) (alphabet.length - 1)) / Math.log(2.0D))) - 1;
                int step = (int) Math.ceil(1.6D * (double) mask * (double) size / (double) alphabet.length);
                StringBuilder idBuilder = new StringBuilder();

                while (true) {
                    byte[] bytes = new byte[step];
                    random.nextBytes(bytes);

                    for (int i = 0; i < step; ++i) {
                        int alphabetIndex = bytes[i] & mask;
                        if (alphabetIndex < alphabet.length) {
                            idBuilder.append(alphabet[alphabetIndex]);
                            if (idBuilder.length() == size) {
                                return idBuilder.toString();
                            }
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("字符序列长度介于1-255");
        }
    }
}
