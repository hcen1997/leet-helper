package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimeTest extends CountPrime {

    @Test
    public void testIsPrimes() {
        boolean primes = isPrimes(4999);
        System.out.println("primes = " + primes);
    }
}