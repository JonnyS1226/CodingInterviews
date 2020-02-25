package chapter6;

/**
 * 二叉树的深度
 */
public class T55_TreeDepth {
    public class BinaryTreeNode{
        BinaryTreeNode left;
        BinaryTreeNode right;
        int val;
    }

    /**
     * 55——1
     */
    public int treeDepth(BinaryTreeNode root)
    {
        if (root == null) return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }


    /**
     * 55_2：判断一棵树是否是AVL 平衡二叉树
     * 方法1：同样如上的方法，判断左右子树深度差是否大于1
     * 方法2：方法1会重复判断多次，所以可以采用后序遍历+实时判定的方法
     *      由于后序遍历序列在遍历到某一个节点时，已经遍历过了其左右子树，于是直接对这个节点进行判定
     */




}
