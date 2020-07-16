package com.ly.customer.customerserver.utils;

import java.util.UUID;

/**
 * AppUtils
 * 生成 APPid 和 APPSecript
 * @author majianxiang
 * @date 2020/4/15
 */
public class AppUtils {

   /* private final static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};*/

    private static final String[] chars = { // <br>
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", // <br>
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", // <br>
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", // <br>
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", // <br>
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", // <br>
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", // <br>
            "Y", "Z", "a1", "a2" // <br>
    };

    public static String getAppId() throws Exception {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 16; i++) {
            String str = uuid.substring(i * 2, i * 2 + 2);
            int x = Integer.parseInt(str, 32);
            shortBuffer.append(chars[x % 0x3E]);
        }

        return shortBuffer.toString();
    }


    /**
     * @description: 生成UUID<br/>
     *               可以确定开头字母来区别业务<br/>
     *               num16：必须是0--15以内的数字<br/>
     *               @param：num16：<br/>
     *               00-->>"0", "1", "2", "3",<br/>
     *               01-->>"4", "5", "6", "7",<br/>
     *               02-->>"8", "9", "a", "b",<br/>
     *               03-->>"c", "d", "e", "f",<br/>
     *               04-->>"g", "h", "i", "j",<br/>
     *               05-->>"k", "l", "m", "n",<br/>
     *               06-->>"o", "p", "q", "r",<br/>
     *               07-->>"s", "t", "u", "v",<br/>
     *               08-->>"w", "x", "y", "z",<br/>
     *               09-->>"A", "B", "C", "D",<br/>
     *               10-->>"E", "F", "G", "H",<br/>
     *               11-->>"I", "J", "K", "L",<br/>
     *               12-->>"M", "N", "O", "P",<br/>
     *               13-->>"Q", "R", "S", "T",<br/>
     *               14-->>"U", "V", "W", "X",<br/>
     */
    public static String uuid(int num16) {
        if (num16 < 0 || num16 > 15) {
            num16 = 0;
        }
        StringBuilder sb = new StringBuilder();
        String pre = Integer.toHexString(num16);
        String uid = pre + UUID.randomUUID().toString().replaceAll("-", "");
        int length = uid.length();
        // 将16进制数转换成64进制数
        // 2的4次方转化成2的6次方的数据
        // bcb da5 f41 172 4bc 28b 920 b1c 5f4 422 6e
        // 3位转2位
        int i = 0;
        for (; i < length; i = i + 3) {
            // 16进制数转化成10进制数
            int end = i + 3;
            if (end >= length) {
                end = length;
            }
            int t = Integer.parseInt(uid.substring(i, end), 16);
            // 10进制数转化成64进制数
            sb.append(chars[t / 64]);// 第一个数据
            sb.append(chars[t % 64]);// 第二个数据
        }
        // write(sb.toString().substring(0, 1) + "----" + sb.toString());
        // System.out.println(sb);
        return sb.toString();
    }





    public static void main(String[] args) throws Exception {

        String appId = getAppId();
        System.out.println("appId = " + appId);

 /*       String uuid = uuid(14);

        System.out.println("uuid = " + uuid);*/

    }
}