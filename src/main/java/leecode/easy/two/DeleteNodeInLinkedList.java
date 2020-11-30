package leecode.easy.two;

import leetcode.ListNode;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node){
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
