package leetcode.level.mid.rand;

import java.util.Arrays;
import java.util.stream.Stream;

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

    private boolean checkV6(String ip) {
        // todo
        return false;
    }

    private boolean checkV4(String ip) {
        if(!只有3个点(ip)){
            return false;
        }
        String[] quadDots  = ip.split("\\.");
        if(quadDots.length!=4){
            return false;
        }
        // 全数字
        long count = Arrays.stream(quadDots).filter(this::isNum).count();
        if(count!=4){
            return false;
        }
        // 开头应为0
        if(Arrays.stream(quadDots).anyMatch(this::startWithZero)){
            return false;
        }
        // 数值范围 0-255
        if(Arrays.stream(quadDots).anyMatch(this::notIpV4NumRange)){
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
        return i>=0 && i<=255;
    }


    boolean notStartWithZero(String s) {
        // 0可以, 单独不行
        int i = Integer.parseInt(s);
        return (i+"").equals(s);
    }

    private boolean isNum(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private boolean 只有3个点(String ip) {
        char[] chars = ip.toCharArray();
        int sum = 0;
        final char dot = '.';
        for (char aChar : chars) {
            sum+=dot==aChar?1:0;
        }
        return sum==3;
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
