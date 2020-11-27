package leetcode.editor.cn;

import leetcode.ListNode;

public class RevertLink {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode parent = null;
        ListNode target = head;
        ListNode next = head.next;
        while (next != null) {
            target.next = parent;

            parent = target;
            target = next;
            next = next.next;
        }
        target.next = parent;
        return target;
    }
}
