package leetcode.level.easy.woked.rand;

public class StudentDoHomework {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int sum = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime<=endTime[i]&&queryTime>=startTime[i]){
                sum++;
            }
        }
        return sum;
    }
}
