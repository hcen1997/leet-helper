package leetcode.easy.rand3;

public class NumberTransZero {
    public int numberOfSteps (int num) {
        int ans = 0;
        while (num!=0){
            if(num%2==1){
                num--;
            }else {
                num /=2;
            }
            ans++;
        }
        return ans;
    }
}
