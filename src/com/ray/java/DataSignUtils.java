package com.ray.java;

import com.sooying.utils.AESUtils;

import java.net.URLDecoder;

/**
 * Created by zhangleilei on 9/22/16.
 */

public class DataSignUtils {

    private static final String AES_KEY = "sooyingsys2016@2";

    // 加密
    public static String encryptData(String dataJson) {
        try {
            return AESUtils.getInstance().encryptToBase64Str(dataJson, AES_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    // 解密
    public static String decryptData(String decodeData) {

        try {
            decodeData = URLDecoder.decode(decodeData, "UTF-8");
            return AESUtils.getInstance(AES_KEY).decryptFromBase64Str(decodeData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        String result = "yGdYNHcfcfweMutUhsBAaDVmWgwtfBSOiuS3vej5cKUtjrWyJAZ8cxufIdulJfFgH35zjQeDmWC\n" +
                "0h6Q2B69Gf5SYIl7k8Hh4DCizbmRM0J5LnZOgcrqcpy530rb4i3PnC1a5wp4xtEaZ+x2YqKoJrbp\n" +
                "XHxJnLe0iiiAWFgQUtz8EmAMS3kX5UJjPIncP+btueMdcTPNAM/Xvt6cnD6BMyuRrJuKExUi9BuR\n" +
                "iO79QhLBA8nJvWscfkms5+5Ojpw+dFZqHzRCokQZ03+1BZuYXGiaCjI7MNSBmT7/B+KQWW0bwGAE\n" +
                "xHq6z85fbBXmiBrsqTqUzajKKwAuxv+2SYahJJQXqCmhObaXVaBbJ+uCSCssu/ObTU0CLNlJc6st\n" +
                "xN/aYlS5j8pxY2Kf2DcGVIKF0A=";

        String deString = decryptData(result);
        System.out.println(deString);
    }

}
