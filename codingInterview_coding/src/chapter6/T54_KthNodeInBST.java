package chapter6;

/**
 * 二叉搜索树的第k大节点
 */
public class T54_KthNodeInBST {

/**
 * 中序遍历序列就是二叉搜索树的从小到大的递增序列
 * 化成中序遍历即可，但同时不用全遍历，遍历到第k大就行了
 */
public class BinaryTreeNode{
    BinaryTreeNode left;
    BinaryTreeNode right;
    int val;
}

private int ans = 0, count = 0;
    public int kthLargest(BinaryTreeNode root, int k) {
        if (root == null || k < 1)
            return -1;
        helper(root, k);
        return ans;
    }

    private void helper(BinaryTreeNode root, int k) {
        if (root.right != null) helper(root.right, k);

        if (++count == k) {
            ans = root.val;
            return;
        }

        if (root.left != null) helper(root.left, k);
    }
}
