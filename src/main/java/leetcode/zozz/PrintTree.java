package leetcode.zozz;


public class PrintTree {
    public static void main(String[] args) {
        int[][] i = {
                {0, 1, 1},
                {0, 1, 1},
                {1},
                {0, 1, 1}
        };


        PrintTree printTree = new PrintTree();
        printTree.print(i);
    }

    private static final String vert = "|  ";
    private static final String vert_left = "|--";
    private static final String corner = "`--";
    private static final String fmt = "%s ";


    private void print(int[][] i) {
        System.out.println(System.currentTimeMillis());
        for (int j = 0; j < i.length; j++) {
            int[] ii = i[j];
            System.out.println(String.format(fmt, j != i.length - 1 ? vert_left : corner) + ii[0]);
            if (ii[0] == 0) {
                String line = j == i.length - 1 ? "    " : String.format(fmt, vert);
                for (int i1 = 1; i1 < ii.length; i1++) {
                    System.out.println(line + String.format(fmt, i1 != ii.length - 1 ? vert_left : corner) + ii[i1]);
                }
            }
        }
    }
    private void indent(int[][] i) {
        System.out.println(System.currentTimeMillis());
        for (int j = 0; j < i.length; j++) {
            int[] ii = i[j];
            // 下面这行和46行应该可以合并的 可能需要先处理一下dir数组
            System.out.println(String.format(fmt, j != i.length - 1 ? vert_left : corner) + ii[0]);
            if (ii[0] == 0) {
                String line = j == i.length - 1 ? "    " : String.format(fmt, vert);
                for (int i1 = 1; i1 < ii.length; i1++) {
                    System.out.println(line + String.format(fmt, i1 != ii.length - 1 ? vert_left : corner) + ii[i1]);
                }
            }
        }
    }
}
