package leetcode.level.easy.two;


import leetcode.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] i = {1,2,1};
        ListNode list = ListNode.getList(i);
        boolean palindrome = new PalindromeLinkedList().isPalindrome(list);
        System.out.println("palindrome = " + palindrome);
    }
    public boolean isPalindrome(ListNode head) {
        // 指向头 走到底 指向底
        // 当前相等么 不相等返回 相等判断下一个
        // 头指向下一个 尾巴根据总体计数 从头再走一遍
        // 当前相等么 ...
        if (head == null) {
            return true;
        }
        int size = getSize(head);
        ListNode p, e;
        for (int i = 0; i < size / 2 + 1; i++) {
            p = moveP(i, head);
            e = moveP(size - i - 1, head);
            if (p.val != e.val) {
                return false;
            }
        }
        return true;
    }

    private ListNode moveP(int i, ListNode head) {
        ListNode p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p;
    }

    private int getSize(ListNode head) {
        int i = 0;
        ListNode p=head;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }
}
