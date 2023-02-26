package leetcode.zozE;

import java.util.PriorityQueue;

public class MaxRatio {
    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
                // a[1]-b[1]==0? a[0]-b[0]: a[1]-b[1]
                double d1 = 1.0*(a[1]-a[0])/a[1]/(a[1]+1);
                double d2 = 1.0*(b[1]-b[0])/b[1]/(b[1]+1);
                return d2-d1>0?1:d2-d1<0?-1:0;
            }
            );
            for(int[] c : classes){
                if(c[0]!=c[1])
                    q.add(c);
            }

            // max double d = m-n/m(m+1)  m小 n也小
            for(int i = 0;i<extraStudents;i++){
                int [] t = q.poll();
                t[0]++;t[1]++;
                q.add(t);
            }
            double ans = 0;
            for(int [] c : classes){
                ans += c[0]*1.0/c[1];
            }
            return ans/classes.length;
        }
    }
}
