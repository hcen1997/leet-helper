package leetcode.editor.cn;

public class LoopLink {
    public static void main(String[] args) {
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow, fast;
        boolean isCycle = false;
        slow = head;
        fast = head;
        while (slow != null) {
            if (fast!=null&&fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
            if (fast == slow) {
                isCycle = true;
                break;
            }
            slow = slow.next;
        }

        return isCycle;
    }
}

