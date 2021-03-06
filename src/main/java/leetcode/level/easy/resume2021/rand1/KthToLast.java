package leetcode.level.easy.resume2021.rand1;

import leetcode.ListNode;

public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode 先锋  = head;
        ListNode ans = head;
        for (int i = 0; i < k; i++) {
            先锋 = 先锋.next;
        }
        while (先锋!=null){
            先锋 = 先锋.next;
            ans = ans.next;
        }
        return ans.val;
    }
}
