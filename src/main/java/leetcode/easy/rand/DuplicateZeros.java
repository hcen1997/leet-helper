package leetcode.easy.rand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int[] a = arr.clone();
        int aI = 0;
        int arrI = 0;
        for (; aI < a.length; ) {
            a[aI] = arr[arrI];
            if (arr[arrI] == 0) {
                aI++;
                if(aI>=a.length){
                    break;
                }
                a[aI] = 0;
            }
            aI++;
            arrI++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
    }
}
