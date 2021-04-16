package ProgrammersLevel3;

import java.util.ArrayList;
import java.util.Collections;

public class RoadSearchGame {
    class TreeNode implements Comparable<TreeNode> {
        int x;
        int y;
        int num;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
            left = right = null;
        }

        @Override
        public int compareTo(TreeNode o) {
            if (y == o.y) return x - o.x;
            else return o.y - y;
        }
    }

    int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        ArrayList<TreeNode> tree = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            tree.add(new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        Collections.sort(tree);

        TreeNode root = tree.get(0);
        for(int i = 1; i < tree.size(); i++){
            addNode(root, tree.get(i));
        }

        preorder(answer, root);
        idx = 0;
        postorder(answer, root);

        return answer;
    }

    public void addNode(TreeNode parent, TreeNode child){
        if(parent.x > child.x){
            if (parent.left == null) parent.left = child;
            else addNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else addNode(parent.right, child);
        }
    }

    public void preorder(int[][] arr, TreeNode root){
        if(root != null){
            arr[0][idx++] = root.num;
            preorder(arr, root.left);
            preorder(arr, root.right);
        }
    }

    public void postorder(int[][] arr, TreeNode root){
        if(root != null){
            postorder(arr, root.left);
            postorder(arr,root.right);
            arr[1][idx++] = root.num;
        }
    }
}
