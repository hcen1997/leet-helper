package leetcode.easy.rand3;

public class DayOfWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        // 天数 默认天数 相除 余数
        int days = calDaysDiff(day, month, year);
        String[] weekDays = {"Sunday", "Monday", "Tuesday",
                "Wednesday", "Thursday", "Friday", "Saturday"};
        String weekDaysEpoch = weekDays[3];
        int index = days % 7;
        index = (index + 3) % 7;
        return weekDays[index];
    }

    private int calDaysDiff(int day, int month, int year) {
        int dd = 1;
        int mm = 1;
        int yy = 1970;
        int sumD, sumMd, sumYd;
        sumD = day - dd;
        sumMd = calMonDiff(month, mm, year);
        sumYd = calYearDiff(year, yy);
        return sumD + sumMd + sumYd;
    }

    private int calYearDiff(int year, int yy) {
        final int nomalYear = 365;
        final int elYear = 366;
        int ans = 0;
        for (int i = yy; i < year; i++) {
            ans += isLeap(i) ? elYear : nomalYear;
        }
        return ans;
    }

    private boolean isLeap(int i) {
        if (i % 400 == 0) {
            return true;
        }
        if (i % 100 == 0) {
            return false;
        }
        if (i % 4 == 0) {
            return true;
        }
        return false;
    }

    private int calMonDiff(int month, int mm, int year) {
        int[] mDs;
        if (isLeap(year)) {
            mDs = new int[]{31, 29, 31,
                    30, 31, 30, 31,
                    31, 30, 31, 30, 31};
        }else {
            mDs = new int[]{31, 28, 31,
                    30, 31, 30, 31,
                    31, 30, 31, 30, 31};

        }
        int diff = month-mm;
        int ans = 0;
        for (int i = 0; i < diff; i++) {
            ans +=mDs[i];
        }
        return ans;

    }
}
