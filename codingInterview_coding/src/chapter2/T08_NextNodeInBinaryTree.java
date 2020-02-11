package chapter2;

/**
 * 08_二叉树的下一个节点
 *      树的结构：有左右子树，还有一个指向父节点的指针
 *      给定一颗二叉树和其中一个节点，找出中序遍历序列的下一个节点。
 */
public class T08_NextNodeInBinaryTree {
    // 树节点数据结构
    public static class BinaryTreeNode{
        String value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        BinaryTreeNode parent;
        public BinaryTreeNode(String x) {this.value = x; }
    }

    public static String findNextNode(BinaryTreeNode treeNode)
    {
        BinaryTreeNode rsNode = null;
        // 1. 右子树不为空：next是右子树的最左子树
        if (treeNode.rightChild != null)
        {
            rsNode = treeNode.rightChild;
            while (rsNode.leftChild != null)
            {
                rsNode = rsNode.leftChild;
            }
        }
        // 2. 右子树为空且是父节点的左子树：next是父节点
        else if (treeNode.parent != null && treeNode.parent.leftChild == treeNode)
        {
            rsNode = treeNode.parent;
        }
        // 3. 右子树为空且是父节点的右子树：next是某个祖先节点的父节点且满足：该祖先节点是父节点的左子树
        else if (treeNode.parent != null && treeNode.parent.rightChild == treeNode)
        {
            rsNode = treeNode.parent;
            while (rsNode != null)
            {
                rsNode = rsNode.parent;
                if (rsNode.parent == null)
                {
                    //为空的情况，直接返回空
                    rsNode = null;
                    break;
                }
                if (rsNode.parent.leftChild == rsNode)
                {
                    rsNode = rsNode.parent;
                    break;
                }
            }
        }
        if (rsNode == null) return "null";
        else
            return rsNode.value;
    }

    // 中序遍历
    public static void printTreeInorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            printTreeInorder(root.leftChild);
            System.out.print(root.value + "  ");
            printTreeInorder(root.rightChild);
        }
    }

    public static void main(String[] args) {
        // 初始化
        BinaryTreeNode root = new BinaryTreeNode("a");
        BinaryTreeNode t2 = new BinaryTreeNode("b");
        BinaryTreeNode t3 = new BinaryTreeNode("c");
        BinaryTreeNode t4 = new BinaryTreeNode("d");
        BinaryTreeNode t5 = new BinaryTreeNode("e");
        BinaryTreeNode t6 = new BinaryTreeNode("f");
        BinaryTreeNode t7 = new BinaryTreeNode("g");
        BinaryTreeNode t8 = new BinaryTreeNode("h");
        BinaryTreeNode t9 = new BinaryTreeNode("i");
        root.leftChild = t2;
        root.rightChild = t3;
        t2.parent = root;
        t3.parent = root;
        t2.leftChild = t4;
        t2.rightChild = t5;
        t4.parent = t2;
        t5.parent = t2;
        t5.leftChild = t8;
        t5.rightChild = t9;
        t8.parent = t5;
        t9.parent = t5;
        t3.leftChild = t6;
        t3.rightChild = t7;
        t6.parent = t3;
        t7.parent = t3;
//        printTreeInorder(root);
//        System.out.println();
        //分别测试：i的下一个，h的下一个，a的下一个，g的下一个
        System.out.println(findNextNode(t9));
        System.out.println(findNextNode(t8));
        System.out.println(findNextNode(root));
        System.out.println(findNextNode(t7));
    }
}
