package leetcode.course;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CutStackTest extends CutStack {
    @Test
    public void cutOncetest() {
        ArrayList<Pice> ans = new ArrayList<>();
        ans.add(new Pice(1,10));
        ArrayList<Pice> pices = cutOnce(ans,3);
        System.out.println("pices = " + pices);
    }
    @Test
    public void cutAll(){
        Pice pice = new Pice(1, 20);
        int i = cutToOne(pice,3);
        System.out.println("i = " + i);
        // 8
    }
    @Test
    public void cutAll1(){
        Pice pice = new Pice(1, 100);
        int i = cutToOne(pice,5);
        System.out.println("i = " + i);
    }
}