package leetcode.easy.rand2;

public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        int indexA = m-1;
        int indexB = n-1;
        for (int i = A.length - 1; i >= 0; i--) {
            if(indexA==-1){
                A[i] = B[indexB];
                indexB--;
                continue;
            }
            if(indexB==-1){
                A[i] = A[indexA];
                indexA--;
                continue;
            }

            if (A[indexA] >= B[indexB]) {
                A[i] = A[indexA];
                indexA--;
            }else {
                A[i] = B[indexB];
                indexB--;
            }
        }
    }
}
