package leetcode.level.easy.woked.rand5;

import leetcode.Node;

import java.util.ArrayList;
import java.util.List;


public class TreePreorder {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        迭代(root, ans);
        return ans;
    }

    public void 递归(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        for (Node child : root.children) {
            递归(child, ans);
        }
    }

    public void 迭代(Node root, List<Integer> ans) {
        ArrayList<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node poll = list.get(0);
            list.remove(0);
            ans.add(poll.val);
            if (poll.children != null && poll.children.size() > 0) {
                for (int i = poll.children.size() - 1; i >= 0; i--) {
//                for (int i = 0; i < poll.children.size(); i++) { // 根据测试用例, 修改正确顺序
                    Node node = poll.children.get(i);
                    list.add(0, node);
                }
            }
        }
    }
}