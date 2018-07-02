package com.baimawanglang.datastructure.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30,
                                        new TreeNode(25, new TreeNode(20, null, null), new TreeNode(27, null, null)),
                                        new TreeNode(32, null, new TreeNode(36, null, null)));
        TreeNode root2 = new TreeNode(30,
                                        new TreeNode(25, new TreeNode(20, null, new TreeNode(22, new TreeNode(21, null, null), new TreeNode(23, null, null))), new TreeNode(27, null, new TreeNode(28, null, new TreeNode(29, null, null)))),
                                        new TreeNode(32, null, new TreeNode(40, new TreeNode(34, null, new TreeNode(35, null, new TreeNode(37, null, null))), null)));
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
        return deptL > deptR ? ++deptL : ++deptR;
    }


    //求高度和最大距离
    public Integer max = 0;
    public int getDepthAndDistance(TreeNode node) {
        if (node == null) {return 0;}
        int leftD = getDepthAndDistance(node.left) + 1;
        int rightD = getDepthAndDistance(node.right) + 1;
        int depth = leftD + rightD;
        if (max < depth) {max = depth;}
        return leftD > rightD ? leftD : rightD;
    }

    /**
     * 求最长距离
     *
     * 最长距离需要减2
     *
     * 而我们要求的二叉树的最大距离其实就是求：肯定是某个节点左子树的高度加上右子树的高度加2，所以求出每个节点左子树和右子树的高度，取左右子树高度之和加2的最大值即可
     * @param root
     * @return
     */
    public static Depth_Distance getDistance(TreeNode root) {
        if (root == null) {return new Depth_Distance();}
        Depth_Distance left = getDistance(root.left);
        Depth_Distance right = getDistance(root.right);
        Depth_Distance max = new Depth_Distance();
        max.depth = Math.max(left.depth + 1, right.depth + 1);
        max.distance = Math.max(Math.max(left.distance, right.distance), left.depth + right.depth + 2);
        return max;
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
