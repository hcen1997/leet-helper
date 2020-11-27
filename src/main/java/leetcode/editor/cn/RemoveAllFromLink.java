package leetcode.editor.cn;

import leetcode.ListNode;

public class RemoveAllFromLink {


    public ListNode removeElements(ListNode head, int val) {
        // 不能老从机器的方面想
        // 机器有问题改机器
        ListNode cp = head;
        ListNode p = null;
        ListNode parent = null;
        if (cp != null) {
            p = head;
            while (p != null) {
                if (p.val == val) {
                    if (parent != null) {
                        parent.next = p.next;
                    }else {
                        cp=p.next;
                    }
                } else {
                    parent = p;
                }
                p = p.next;
            }
        }
        return cp;
    }
}
