package com.baimawanglang.tree;

public class TreeTest {

    public static void main(String[] args) {

    }

    //获取树高度
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {return 0;}
        int deptL = getTreeDepth(root.left);
        int deptR = getTreeDepth(root.right);
        return deptL > deptR ? deptL : deptR;
    }





}
