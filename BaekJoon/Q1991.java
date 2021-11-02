package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {    // 트리 순회
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.addNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.preorder(tree.root);
        sb.append('\n');

        tree.inorder(tree.root);
        sb.append('\n');

        tree.postorder(tree.root);
        System.out.println(sb);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    static class Tree {
        Node root;

        public void addNode(char value, char left, char right) {
            if (root == null) {
                root = new Node(value);
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root, value, left, right);
            }
        }

        public void searchNode(Node root, char value, char left, char right) {
            if (root == null) return;

            if (root.value == value) {
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                searchNode(root.left, value, left, right);
                searchNode(root.right, value, left, right);
            }
        }

        public void preorder(Node root) {
            sb.append(root.value);
            if (root.left != null) preorder(root.left);
            if (root.right != null) preorder(root.right);
        }

        public void inorder(Node root) {
            if (root.left != null) inorder(root.left);
            sb.append(root.value);
            if (root.right != null) inorder(root.right);
        }

        public void postorder(Node root) {
            if (root.left != null) postorder(root.left);
            if (root.right != null) postorder(root.right);
            sb.append(root.value);
        }
    }
}
