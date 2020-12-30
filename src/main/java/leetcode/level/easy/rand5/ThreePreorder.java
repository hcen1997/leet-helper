package leetcode.level.easy.rand5;

import leetcode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class ThreePreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            ans.add(poll.val);
            if (poll.children != null&&poll.children.size()>0) {
                for (int i = 0; i < poll.children.size(); i++) {
                    Node node = poll.children.get(i);
                    queue.offer(node);
                }
            }
            // todo: 中序遍历改为前序遍历
        }
        return ans;
    }
}