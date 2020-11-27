package leetcode;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode getList(int[] ints) {
        ListNode parent = null;
        ListNode head = null;
        for (int anInt : ints) {
            ListNode listNode = new ListNode(anInt);
            if (head == null) {
                head = listNode;
            }
            if (parent != null) {
                parent.next = listNode;
            }
            parent = listNode;
        }
        return head;
    }
}
