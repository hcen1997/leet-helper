package leetcode.level.easy.woked.rand2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        PriorityQueue<Character> cq = new PriorityQueue<>(
                Comparator.comparingInt(c -> -c));
        cq.add(keysPressed.charAt(0));
        for (int i = 1; i < releaseTimes.length; i++) {
            int d = releaseTimes[i] - releaseTimes[i - 1];
            if (d >= max) {
                if (d > max) {
                    cq.clear();
                }
                max = d;
                cq.add(keysPressed.charAt(i));
            }
        }
        return cq.peek();
    }
}
