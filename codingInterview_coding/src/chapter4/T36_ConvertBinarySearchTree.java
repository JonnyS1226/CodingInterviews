package chapter4;

/**
 * 二叉搜索树和双向链表
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新节点，只能调整树中节点指针的指向
 */
public class T36_ConvertBinarySearchTree {
    public static class BinaryTreeNode{
        BinaryTreeNode left;
        BinaryTreeNode right;
        int val;
    }

    /**
     * 思想：通过类似先序遍历的思想，将根节点分别与其左右子节点连出双向，反映在遍历序列上就是：
     *      每一个点和其前面那个点建立双向关系
     * @param root
     * @return
     */
    public static BinaryTreeNode convert(BinaryTreeNode root)
    {
        if (root == null) return null;
        BinaryTreeNode preNode = null;
        convertNode(root, preNode);
        //寻找建立双向链表后的头结点，即二叉树最左边那个（值最小的）
        while (root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    /**
     * 分析时可以通过结合先序遍历的序列进行分析，本质上其实是先序遍历的序列不断向后遍历，并且依次建立双链
     * @param node
     * @param preNode
     */
    public static void convertNode(BinaryTreeNode node, BinaryTreeNode preNode)
    {
        if (node == null) return;
        BinaryTreeNode curr = node;
        //先判定左子树
        if (curr.left != null)
            convertNode(curr.left, preNode);
        //建立双向链接
        curr.left = preNode;
        if (preNode.right != null)
        {
            preNode.right = curr;
        }
        preNode = curr;
        //判定右子树
        if (curr.right != null)
            convertNode(curr.right, preNode);
    }

}
