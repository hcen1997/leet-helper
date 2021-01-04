package leetcode.level.mid.rand;

import java.util.Arrays;

public class ValidateIpAddress {
    public static final String v4 = "IPv4";
    public static final String v6 = "IPv6";
    public static final String notV = "Neither";

    public String validIPAddress(String IP) {
        if (!validIpString(IP)) {
            return notV;
        }
        if (checkV4(IP)) {
            return v4;
        }
        if (checkV6(IP)) {
            return v6;
        }
        return notV;
    }

    /**
     * ipv6格式上是v4的升级版
     * 3点->7冒号
     * 10进制-> 16进制
     * // 总结: ipv6可以比v4容纳更多机器地址
     */
    private boolean checkV6(String ip) {
        final int v6GroupSize = 8;
        if (!只有7个冒号(ip)) {
            return false;
        }
        ip = ip.toUpperCase();
        String[] colons = ip.split(":");
        // 这里可能有问题(ipv6中多个0值可以省略不写
        if (colons.length != v6GroupSize
                || Arrays.stream(colons).anyMatch(String::isEmpty)) {
            return false;
        }
        // 全数字
        long count = Arrays.stream(colons).filter(this::isHexChar).count();
        if (count != v6GroupSize) {
            return false;
        }
        // 最多4位数
        if (Arrays.stream(colons).anyMatch(s -> s.length() > 4)) {
            return false;
        }
        // 数值范围 0-255
        return true;
    }

    private boolean isHexChar(String target) {
        final String hexCharSet = "1234567890ABCDEFabcdef";
        return checkCharSet(target, hexCharSet);
    }


    private boolean checkV4(String ip) {
        if (!只有3个点(ip)) {
            return false;
        }
        String[] quadDots = ip.split("\\.");
        if (quadDots.length != 4
                || Arrays.stream(quadDots).anyMatch(String::isEmpty)) {
            return false;
        }
        // 全数字
        long count = Arrays.stream(quadDots).filter(this::isNum).count();
        if (count != 4) {
            return false;
        }
        // 开头应为0
        if (Arrays.stream(quadDots).anyMatch(this::startWithZero)) {
            return false;
        }
        // 数值范围 0-255
        if (Arrays.stream(quadDots).anyMatch(this::notIpV4NumRange)) {
            return false;
        }
        return true;

    }

    private boolean startWithZero(String s) {
        return !notStartWithZero(s);
    }

    private boolean notIpV4NumRange(String s) {
        return !ipV4NumRange(s);
    }

    private boolean ipV4NumRange(String s) {
        int i = Integer.parseInt(s);
        return i >= 0 && i <= 255;
    }


    /**
     * @return false : 以0开头 / 不是一个正常数
     */
    boolean notStartWithZero(String s) {
        // 0可以, 单独不行
        try {
            int i = Integer.parseInt(s);
            return (i + "").equals(s);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNum(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private boolean 只有7个冒号(String ip) {
        final char colon = ':';
        int sum = countChar(ip, colon);
        return sum == 7;
    }

    private boolean 只有3个点(String ip) {
        final char dot = '.';
        int sum = countChar(ip, dot);
        return sum == 3;
    }

    private int countChar(String ip, char dot) {
        char[] chars = ip.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += dot == aChar ? 1 : 0;
        }
        return sum;
    }

    private boolean validIpString(String ip) {
        final String charSet = ".:" +
                "qwertyuiopasdfghjklzxcvbnm" +
                "QWERTYUIOPASDFGHJKLZXCVBNM" +
                "1234567890";
        // ip 应为 charSet 中的某个字符
        return checkCharSet(ip, charSet);
    }

    boolean checkCharSet(String a, String set) {
        char[] target = a.toCharArray();
        char[] charSet = set.toCharArray();

        for (char c : target) {
            if (!InSet(charSet, c)) {
                return false;
            }
        }
        return true;
    }

    private boolean InSet(char[] charSet, char c) {
        for (char element : charSet) {
            if (element == c) {
                return true;
            }
        }
        return false;
    }
}
