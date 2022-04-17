package com.baimawanglang.datastructure.node;

public class NodeTest {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        System.out.println(root.toString());
        Node node = reverseNode(root);
        System.out.println(node.toString());
    }

    // 链表反转
    public static Node reverseNode(Node root) {
        Node prev = null;
        while(root != null) {
            Node next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        return prev;
    }

    // 链表合并

}
