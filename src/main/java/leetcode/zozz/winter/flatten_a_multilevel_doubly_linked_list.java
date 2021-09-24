package leetcode.zozz.winter;

import leetcode.Utils;

import java.util.ArrayList;
import java.util.List;

/*
// 每日一题 20210924
多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class flatten_a_multilevel_doubly_linked_list {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node strToNode() {
        String s = "[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]";
        String[] split = s.substring(1, s.length() - 1).split(",");


        Node h = null, t;
        int i = 0;
        for (; i < split.length; i++) {
            String s1 = split[i];
            if (!s1.equals("null")) {
                t = new Node();
                t.val = Integer.parseInt(s1);
                t.prev = h;
                h = t;
            } else {
                break;
            }
        }
        while (h.prev != null) {
            h = h.prev;
        }
        while (h.next != null) {
//            split[]
        }
        return null;
    }

    class Solution {
        List<Node> stack = new ArrayList<>();

        public Node flatten(Node head) {
            dfs(head);
            for (int i = 0; i < stack.size(); i++) {
                Node node = stack.get(i);
                node.prev = i == 0 ? null : stack.get(i - 1);
                node.next = i == stack.size() - 1 ? null : stack.get(i + 1);
                node.child = null;
            }
            return head;
        }

        private void dfs(Node head) {
            if (head == null) return;
            stack.add(head);
            dfs(head.child);
            dfs(head.next);
        }

        /**
         * sb 一堆bug  , 我用栈了
         */
        private Node f(Node head, Node prev, Node next, boolean inChild) {
            System.out.printf("head %s prev %s next %s inChild %s\n", head.val, prev == null ? null : prev.val,
                    next == null ? null : next.val, inChild);
            if (head.child != null) {
                f(head.child, head, head.next, true);
            }
            if (head.next != null) {
                f(head.child, head, head.next, true);
            }
            head.prev = head.prev == null ? prev : head.prev;
            Node n = head.next;
            head.next = !inChild && head.child == null ? head.next
                    : !inChild && head.child != null ? head.child
                    : inChild && head.child == null && head.next != null ? head.next
                    : inChild && head.child != null && head.next != null ? head.child
                    : inChild && head.child == null && head.next == null ? next : null;
            if (inChild && head.child == null && n == null) {
                head.next.prev = head;
            }
            head.child = null;

            System.out.printf("    head %s prev %s next %s  \n",
                    head.val, head.prev == null ? null : head.prev.val,
                    head.next == null ? null : head.next.val);
            return head;
        }
    }

    /*
head 1 prev null next 2 inChild false
head 2 prev 1 next 3 inChild false
head 3 prev 2 next 4 inChild false
head 7 prev 3 next 4 inChild true
head 8 prev 7 next 4 inChild true
head 11 prev 8 next 9 inChild true
head 12 prev 11 next 9 inChild true
    head 12 prev 11 next 9
    head 11 prev 8 next 12
head 9 prev 8 next 4 inChild true
head 10 prev 9 next 4 inChild true
    head 10 prev 9 next 4
    head 9 prev 8(12) next 10
    head 8 prev 7 next 11
    head 7 prev 3 next 8
head 4 prev 3 next 5 inChild false
head 5 prev 4 next 6 inChild false
head 6 prev 5 next null inChild false
    head 6 prev 5 next null
    head 5 prev 4 next 6
    head 4 prev 3(10) next 5
    head 3 prev 2 next 7
    head 2 prev 1 next 3
    head 1 prev null next 2




    * */
}
