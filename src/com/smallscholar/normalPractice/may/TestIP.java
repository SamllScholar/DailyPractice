package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/20 13:56
 * @describe 验证IP地址
 */
public class TestIP {

    public String solve(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':') {
            return "Neither";
        }
        // 先使用'.'分割一下, 如果可以分割并且长度为4, 就证明是ipv4的地址格式, 否则就证明是否是ipv6的格式, 如果
        // 使用':'分割后的长度为8, 那么就是ipv6的地址格式, 如果都不是那么就不是一个合法的ip地址
        String[] c = IP.split("\\.");
        if (c.length != 4) {
            // 证明了不是ipv4, 接下来证明是否是ipv6
            c = IP.split(":");
            // 如果分割后的长度不为8那么就不是一个合法的ip地址
            if (c.length != 8) {
                return "Neither";
            } else {
                // 如果一个地址是ipv6的那么地址的每一部分, 只能由大小写字母和数字组成并且长度不能超过四
                // 使用一个正则表达式来判断是否有字母或数字组成
                String regex = "^[A-Fa-f0-9]+$";
                for (int i = 0; i < 8; i++) {
                    String s = c[i];
                    if (s.length() > 4 || !s.matches(regex)) {
                        return "Neither";
                    }
                }
                return "IPv6";
            }
        } else {
            for (int i = 0; i < 4; i++) {
                String s = c[i];
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) > '9' || s.charAt(j) < '0') {
                        return "Neither";
                    }
                }
                int num = Integer.parseInt(s);
                // 判断一下是否有前导0或者地址的大小大于255
                if (num > 255 || (c[i].charAt(0) == '0' && num > 0)) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }

}
