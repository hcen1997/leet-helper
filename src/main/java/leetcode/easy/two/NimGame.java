package leetcode.easy.two;

public class NimGame {

    /**
     * me first
     */
    public boolean canWinNim(int n) {
        boolean[] canWin = {
                true,
                true,
                true,
                false,  // 4
        };
        if(n<=4){
            return canWin[n-1];
        }else {
            // n == 4k + 0 => t = 0 => index=3
            // n == 4k + 1 => t = 1 => index=0
            // n == 4k + 2 => t = 2 => index=1
            // n == 4k + 3 => t = 3 => index=2
            return canWin[((n&3)+3)%4];
        }
    }
}
