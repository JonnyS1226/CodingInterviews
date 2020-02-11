package chapter2;

/**
 * 07_输入某二叉树的前序遍历和中序遍历的结果，来重构二叉树
 */
public class T07_ConstructBinaryTree {
    // 二叉树结点类
    public static class BinaryTreeNode{
        int val;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
    }

    // 思路：前序遍历第一个元素就是根，根据该元素在中序遍历中找到树的左右子树，左右子树使用递归

    /**
     * 具体的构造函数
     * @param preOrder 先序遍历序列
     * @param preStart 先序遍历开始
     * @param preEnd   先序遍历结束
     * @param inOrder  中序遍历序列
     * @param inStart  中序遍历开始
     * @param inEnd    中序遍历结束
     * @return  构造的树的根结点
     */
    public static BinaryTreeNode reconstructBinaryTree(
            int[] preOrder, int preStart, int preEnd,
            int[] inOrder, int inStart, int inEnd
    )
    {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preOrder[preStart];
        int indexIn = inStart;
        while (indexIn <= inEnd && inOrder[indexIn] != rootVal) {
            indexIn++;
        }
        if (indexIn > inEnd) {
            throw new IllegalArgumentException("invalid");
        }
        BinaryTreeNode rs = new BinaryTreeNode();
        rs.val = rootVal;
        // 范围要注意，左子树的长度是indexIn - inStart，
        // 故左子树的先序遍历范围[preStart + 1, indexIn - inStart + preStart]
        // 左子树的中序遍历范围[inStart, indexIn - 1]
        rs.leftChild = reconstructBinaryTree(preOrder, preStart + 1, preStart + indexIn - inStart,
                inOrder, inStart, indexIn - 1);
        // 右子树的先序遍历范围[先序遍历左子树结束点+1, preEnd]
        // 右子树的中序遍历范围[indexIn + 1, inEnd]
        rs.rightChild = reconstructBinaryTree(preOrder, preStart + indexIn - inStart + 1, preEnd, inOrder,
                indexIn + 1, inEnd);
        return rs;
    }

    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder)
    {
        if (preOrder == null || inOrder == null || inOrder.length != preOrder.length)
        {
            return null;
        }
        return reconstructBinaryTree(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    /**
     * 以下是先序，中序和后序遍历输出树
     */
    public static void printTreeInorder(BinaryTreeNode root) {
        if (root != null) {
            printTreeInorder(root.leftChild);
            System.out.print(root.val + " ");
            printTreeInorder(root.rightChild);
        }
    }

    public static void printTreePreorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.val + " ");
            printTreePreorder(root.leftChild);
            printTreePreorder(root.rightChild);
        }
    }


    public static void printTreePostorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            printTreePostorder(root.leftChild);
            printTreePostorder(root.rightChild);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preOrder, inOrder);
        System.out.print("中序遍历：");
        printTreeInorder(root);
        System.out.println();
        System.out.print("先序遍历：");
        printTreePreorder(root);
        System.out.println();
        System.out.print("后序遍历：");
        printTreePostorder(root);
    }

}
