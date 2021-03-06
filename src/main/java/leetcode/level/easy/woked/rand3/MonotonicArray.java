package leetcode.level.easy.woked.rand3;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if(A.length==1){
            return true;
        }

        for (int i = 0; i < A.length-1; i++) {
            if(A[i]>A[i+1]){
                for (int j = i; j < A.length - 1; j++) {
                    if(A[i]<A[i+1]){
                        return false;
                    }
                }
                return true;
            }else if(A[i]<A[i+1]){
                for (int j = i; j < A.length - 1; j++) {
                    if(A[i]>A[i+1]){
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
