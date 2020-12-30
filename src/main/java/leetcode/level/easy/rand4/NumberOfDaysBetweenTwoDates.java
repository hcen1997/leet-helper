package leetcode.level.easy.rand4;

import static java.time.Year.isLeap;

public class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        int[] ints1 = stringToDate(date1);
        int[] ints2 = stringToDate(date2);

        int d1 = calDaysToOne(ints1[0], ints1[1], ints1[2]);
        int d2 = calDaysToOne(ints2[0], ints2[1], ints2[2]);
        return Math.abs(d1 - d2);
    }
    public static boolean isLeap(long year) {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }
    int calDaysToOne(int y, int m, int d) {
            y--;
        int normal = y * 365;
        int leap = y / 4 - y / 100 + y / 400;
        int[] mMap = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int[] mMapLeap = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};

        int yd = normal + leap;
        int md = isLeap(y+1) ? mMapLeap[m - 1] : mMap[m - 1];
        int dd = d - 1;
        return yd + md + dd;

    }

    int[] stringToDate(String date) {
        int[] ans = new int[3];
        String[] split = date.split("-");
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(split[i]);
        }
        return ans;
    }

}
