package leetcode.level.easy.rand4;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        int i = Math.toIntExact(Math.round(sqrt));
        int par = getPar(area, i);
        int l = 1;
        int w = area;
        l = Math.max(par,area/par);
        w = Math.min(par,area/par);
        return new int[]{l,w};
    }

    int getPar(int area, int i) {
        int j;
        int target = 1;
        for (j = i; j >= 1; j--) {
            target = area / j;
            if (target * j == area) {
                break;
            }
        }
        return target;
    }
}
