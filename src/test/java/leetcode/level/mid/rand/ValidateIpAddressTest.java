package leetcode.level.mid.rand;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateIpAddressTest extends ValidateIpAddress {

    @Test
    public void testValidIPAddressV4() {
        assertEquals(v4,validIPAddress("1.1.1.1"));
        assertEquals(v4,validIPAddress("172.16.254.1"));
    }
    @Test
    public void testValidIPAddressV6() {
        assertEquals(v6,validIPAddress("fe80::5d0d:40a7:36f5:2c85"));
        assertEquals(v6,validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
    @Test
    public void testValidIPAddressNether() {
        assertEquals(notV,validIPAddress("01.1.1.1"));
        assertEquals(notV,validIPAddress("256.256.256.256"));
        assertEquals(notV,validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        assertEquals(notV,validIPAddress("1e1.4.5.6"));
    }

    @Test
    public void testNotStartWithZeroTrue() {
        assertTrue(notStartWithZero("10"));
        assertTrue(notStartWithZero("0"));
        assertTrue(notStartWithZero("1001"));
    }
    @Test
    public void testNotStartWithZeroFalse() {
        assertFalse(notStartWithZero("010"));
        assertFalse(notStartWithZero("00"));
        assertFalse(notStartWithZero("0100"));
    }

    final String charSet = ".:" +
            "qwertyuiopasdfghjklzxcvbnm" +
            "QWERTYUIOPASDFGHJKLZXCVBNM" +
            "1234567890";
    @Test
    public void testCheckCharSetTrue() {
        // ip 应为 charSet 中的某个字符
        assertTrue(checkCharSet("ip", charSet));
    }
    @Test
    public void testCheckCharSetFalse() {
        assertFalse(checkCharSet("i p", charSet));
    }
}