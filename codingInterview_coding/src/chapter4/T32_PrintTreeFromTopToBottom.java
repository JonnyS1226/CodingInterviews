package chapter4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 从上到下，从左到右打印二叉树
 *          即层次遍历
 */
public class T32_PrintTreeFromTopToBottom {
    public static class BinaryTreeNode{
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int val;
    }

    /**
     * 32_1:常规的层次遍历
     * 非递归，使用队列
     * @param root
     */
    public static void printLevelNoRecur(BinaryTreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.leftChild != null)
                queue.offer(curr.leftChild);
            if (curr.rightChild != null)
                queue.offer(curr.rightChild);
        }
    }

    /**
     * 分行从上到下打印二叉树，形成一个三角形的输出结构
     * @param root
     */
    public static void advancedPrint(BinaryTreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        //下面两个变量分别是 下一行的节点树，这一行尚需打印的节点数
        int nextLevelNum = 0;
        int toBePrinted = 1;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            toBePrinted--;
            if (curr.leftChild != null)
            {
                queue.offer(curr.leftChild);
                nextLevelNum++;
            }
            if (curr.rightChild != null)
            {
                queue.offer(curr.rightChild);
                nextLevelNum++;
            }
            if (toBePrinted == 0)
            {
                System.out.print("\n");
                toBePrinted = nextLevelNum;
                nextLevelNum = 0;
            }
        }
    }

    /**
     * 32_3
     * 之字形打印二叉树，即第一行从左到右，第二行从右到左
     * 使用两个栈，栈1和栈2
     * 根节点为第一层，打印一个节点的时候要将其子节点入栈
     * 当前打印奇数层时，先保存左，再右 到第一个栈中
     * 当前打印偶数层时，先保存右，再左 到第二个栈中
     * 同时要按照32_2的方法进行逐行打印，但是这里只要其中一个栈不为空，就说明这一行没有打印完
     * @param root
     */
    public static void printInZHI(BinaryTreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Stack<BinaryTreeNode> stackEven = new Stack<>();
        Stack<BinaryTreeNode> stackOdd = new Stack<>();
        stackOdd.push(root);
        while (!stackEven.isEmpty() || !stackOdd.isEmpty())
        {
            if (!stackOdd.isEmpty())
            {
                while (!stackOdd.isEmpty())
                {
                    BinaryTreeNode curr = stackOdd.pop();
                    System.out.print(curr.val + " ");
                    if (curr.leftChild != null) stackEven.push(curr.leftChild);
                    if (curr.rightChild != null) stackEven.push(curr.rightChild);
                }
            }
            else
            {
                while (!stackEven.isEmpty())
                {
                    BinaryTreeNode curr = stackEven.pop();
                    System.out.print(curr.val + " ");
                    if (curr.rightChild != null) stackOdd.push(curr.rightChild);
                    if (curr.leftChild != null) stackOdd.push(curr.leftChild);
                }
            }
            System.out.println();
        }
    }
}
