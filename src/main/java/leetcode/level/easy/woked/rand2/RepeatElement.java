package leetcode.level.easy.woked.rand2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RepeatElement {
    public int repeatedNTimes(int[] A) {
        Integer[] indexRand = new Integer[A.length];
        for (int i = 0; i < indexRand.length; i++) {
            indexRand[i] = i;
        }
        List<Integer> idRand = Arrays.asList(indexRand);
        Collections.shuffle(idRand, ThreadLocalRandom.current());

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i+1; j < A.length; j++) {
                Integer ii = idRand.get(i);
                Integer jj = idRand.get(j);
                if (A[ii] == A[jj]) {
                    return A[ii];
                }
            }
        }
        int target = ThreadLocalRandom.current().nextInt(A.length);
        return A[target];
    }
}
