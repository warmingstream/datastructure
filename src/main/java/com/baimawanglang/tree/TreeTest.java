package com.baimawanglang.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30,
                                        new TreeNode(25, new TreeNode(20, null, null), new TreeNode(27, null, null)),
                                        new TreeNode(32, null, new TreeNode(36, null, null)));
        TreeNode publicNode = getPublicNode(root, new TreeNode(36), new TreeNode(36));
        System.out.println(publicNode);
    }

    //遍历二叉树
    public static void outTree(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();

        System.out.print("\r\n后序遍历:");
        putListAfter(root, result);
        outputList(result);

        System.out.print("\r\n前序遍历:");
        result = new LinkedList<Integer>();
        putListBefore(root, result);
        outputList(result);

        System.out.print("\r\n中序遍历:");
        result = new LinkedList<Integer>();
        putListMid(root, result);
        outputList(result);
    }

    //中序遍历
    private static void putListMid(TreeNode root, List<Integer> result) {
        if (root == null) { return;}
        putListMid(root.left, result);
        result.add(root.val);
        putListMid(root.right, result);
    }

    //后序遍历
    private static void putListAfter(TreeNode root, List<Integer> result) {
        if (root == null) { return;}
        putListAfter(root.left, result);
        putListAfter(root.right, result);
        result.add(root.val);
    }

    //前序遍历
    private static void putListBefore(TreeNode root, List<Integer> result) {
        if (root == null) { return;}
        result.add(root.val);
        putListBefore(root.left, result);
        putListBefore(root.right, result);
    }

    //求树高度
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {return 0;}
        int deptL = getTreeDepth(root.left);
        int deptR = getTreeDepth(root.right);
        return deptL > deptR ? deptL : deptR;
    }

    //求两节点最近公共父节点
    public static TreeNode getPublicNode(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {return null;}
        else if (node1.val < root.val && node2.val < root.val) {return getPublicNode(root.left, node1, node2);}
        else if (node1.val > root.val && node2.val > root.val) {return getPublicNode(root.right, node1, node2);}
        else {return root;}
    }

    //输出list
    public static void outputList(List<Integer> list) {
        for (Integer integer: list){ System.out.print(integer + "  "); }
    }

}
