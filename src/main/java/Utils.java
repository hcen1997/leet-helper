import java.util.ArrayList;

public class Utils {
//    int[] trans(String s){
//        assert s.indexOf("[")==0;
//        assert s.indexOf("]")==s.length()-1;
//        String nums = s.substring(1, s.length() - 1);
//        String[] split = nums.split(",");
//    }
//
//    public static void main(String[] args) {
//        String[] s = {
//                "[]",
//                "[0]",
//                "[  ]"
//        }
//    }
    public static int[] toArray(ArrayList<Integer> nums){
        int[] ints = new int[nums.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = nums.get(i);
        }
        return ints;
    }
}
