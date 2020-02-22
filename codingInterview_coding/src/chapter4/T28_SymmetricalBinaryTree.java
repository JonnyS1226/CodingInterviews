package chapter4;

/**
 * 对称的二叉树
 *      实现一个函数来判断一棵二叉树是否是对称的
 */
public class T28_SymmetricalBinaryTree {
    public static class BinaryTreeNode{
        int val;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
    }

    /**
     * 思想：前序遍历是根-左-右，定义一种遍历：根-右-左，两者序列结果若一样，则是对称的
     *      边界情况：一颗二叉树全是相同个数的一个值，但是结构不一样，显然不对称，但是遍历序列一定相同
     *              这种情况要将子节点是null的情况也考虑到遍历序列中即可
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        if (root1 == null && root2 == null) return true;
        if (root1 != null || root2 != null) return false;
        if (root1.val != root2.val) return false;
        return isSymmetrical(root1.leftChild, root2.rightChild)
                && isSymmetrical(root1.rightChild, root2.leftChild);
    }

    public static boolean isSymmetrical(BinaryTreeNode root)
    {
        return isSymmetrical(root, root);
    }

}
