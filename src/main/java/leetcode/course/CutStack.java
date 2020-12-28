package leetcode.course;

import java.util.ArrayList;

public class CutStack {
    public int cutToOne(Pice p ,int maxTime) {
        ArrayList<Pice> input = new ArrayList<>();
        int ans = 0;
        input.add(p);
        ArrayList<Pice> pices = cutOnce(input,maxTime);
        System.out.println("pices = " + pices);
        ans++;
        while (pices.size() > 0) {
            pices = cutOnce(pices,maxTime);
            System.out.println("pices = " + pices);
            ans++;
        }
        return ans;
    }

    public ArrayList<Pice> cutOnce(ArrayList<Pice> start,int maxTime) {
        ArrayList<Pice> ans = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            Pice pice1 = start.get(i);
            if (i >= maxTime) {
                ans.add(pice1);
            } else {
                ArrayList<Pice> two = cut(pice1);
                ans.addAll(two);
            }
        }
        ans.removeIf(pice -> pice.e == pice.s);
        return ans;
    }

    private ArrayList<Pice> cut(Pice pice) {
        ArrayList<Pice> ans = new ArrayList<>();
        int length = pice.e - pice.s + 1;
        Pice pice1;
        Pice picee;
        int firstLast;
        if (length % 2 == 0) {
            firstLast = pice.s + length / 2 - 1;
        } else {
            firstLast = pice.s + length / 2 - 1;
        }
        pice1 = new Pice(pice.s, firstLast);
        picee = new Pice(firstLast + 1, pice.e);
        ans.add(pice1);
        ans.add(picee);
        return ans;
    }


    class Pice {
        public int s;
        public int e;

        public Pice(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return String.format("P{%d,%d}", s, e);
        }
    }
}
