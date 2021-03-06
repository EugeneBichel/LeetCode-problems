package com.bichel.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthSmallestElementInABSTTest {
    @Test
    public void test1() {
        //1 2 3 4 5
        TreeNode root = TreeNode.insertNode(null, 3);
        TreeNode.insertNode(root, 2);
        TreeNode.insertNode(root, 4);
        TreeNode.insertNode(root, 1);
        TreeNode.insertNode(root, 5);

        KthSmallestElementInABST pr = new KthSmallestElementInABST();
        int k = 1;
        int expected = 1;
        int actual = pr.kthSmallest(root, k);

        Assertions.assertEquals(expected, actual);
    }
}
