package com.bichel.leetcode.tree;

import org.junit.jupiter.api.Test;

public class LowestCommonAncestorTest {

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.left.left = new TreeNode(8);

        LowestCommonAncestor pr = new LowestCommonAncestor();

        TreeNode lca = pr.lowestCommonAncestor(root,
                new TreeNode(5), new TreeNode(10));

        if (lca != null)
            System.out.println(lca.val);
        else
            System.out.println("null");
    }
}
