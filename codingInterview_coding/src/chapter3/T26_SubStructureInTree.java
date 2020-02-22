package chapter3;

/**
 * 树的子结构
 *      输入两棵二叉树A和B，判断B是不是A的子结构
 */
public class T26_SubStructureInTree {
    public static class BinaryTreeNode
    {
        int val;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
    }

    /**
     * 使用递归解决
     * 先判断根节点是否同，相同则再判断左右子结点，不同则再找这棵树看看有没有与子树相同的根节点
     * @param Root
     * @param subRoot
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root, BinaryTreeNode subRoot)
    {
        boolean result = false;
        if (root != null && subRoot != null)
        {
            if (root.val == subRoot.val)
            {
                result = hasSubTreeCore(root, subRoot);
            }
            if (!result)
            {
                hasSubTree(root.leftChild, subRoot);
            }
            if (!result)
            {
                hasSubTree(root.rightChild, subRoot);
            }
        }
        return result;
    }

    /**
     * 具体的判断
     * @param Root
     * @param subRoot
     * @return
     */
    public static boolean hasSubTreeCore(BinaryTreeNode root, BinaryTreeNode subRoot)
    {
        if (root == null)
        {
            return false;
        }
        if (subRoot == null)
        {
            return true;
        }
        if (root.val != subRoot.val)
        {
            return false;
        }
        return hasSubTreeCore(root.leftChild, subRoot.rightChild) && hasSubTreeCore(root.rightChild, subRoot.rightChild);
    }


}
