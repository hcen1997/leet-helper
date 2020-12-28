package leetcode.level.easy.rand3;

public class Fib01 {
        public int fib(int n) {
            int i0 = 0;
            int i1 = 1;
            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            int ans = 0;
            for (int i = 2; i <=n; ) {
                ans = i0+i1;
                ans = ans%1000000007;
                i++;
                i0=i1;
                i1=ans;
            }
            return ans;
        }
}
