package chapter4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树镜像
 */
public class T27_MirrorOfBinaryTree {
    public static class BinaryTreeNode{
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int val;
    }

    /**
     * 递归求二叉树镜像
     * 思想：当一个节点有子节点，就交换它两个子节点即可（即使其中一个是null）
     * @param root
     * @return
     */
    public static void mirrorOfBinaryTreeRecursive(BinaryTreeNode root)
    {
        if (root == null) return;
        if (root.leftChild == null && root.rightChild == null) return;
        //有子结点
        BinaryTreeNode tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;
        if (root.rightChild != null) mirrorOfBinaryTreeRecursive(root.rightChild);
        if (root.leftChild != null) mirrorOfBinaryTreeRecursive(root.leftChild);
    }

    /**
     * 同样的思想，使用非递归之 层次遍历，遇到有子节点的就交换子节点
     * 层次遍历的思想：先入队根节点，出队根，入队其两个子节点，依次出队。。。直到队列为空，遍历结束
     * @param root
     * @return
     */
    public static void mirrorOfBinaryTreeLevel(BinaryTreeNode root)
    {
        if (root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNode curr = queue.poll();
            if (curr.rightChild != null || curr.leftChild != null)
            {
                BinaryTreeNode tmp = curr.leftChild;
                curr.leftChild = curr.rightChild;
                curr.rightChild = tmp;
            }
            if (curr.leftChild != null) queue.offer(curr.leftChild);
            if (curr.rightChild != null) queue.offer(curr.rightChild);
        }
    }

    /**
     * 非递归之 先序遍历1，遇到有子节点的就交换子结点
     * 先序遍历的非递归思想：使用栈存放遍历序列
     * @param root
     */
    public static void mirrotOfBinaryTreePreorder1(BinaryTreeNode root)
    {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty())
        {
            BinaryTreeNode curr = stack.pop();
            if (curr.leftChild != null || curr.rightChild != null)
            {
                BinaryTreeNode tmp = curr.leftChild;
                curr.leftChild = curr.rightChild;
                curr.rightChild = tmp;
            }
            if (curr.rightChild != null) stack.push(curr.rightChild);
            if (curr.leftChild != null) stack.push(curr.leftChild);
        }
    }

    /**
     * 非递归之 先序遍历2，遇到有子节点的就交换子结点
     * 先序遍历的非递归思想：
     * @param root
     */
    public static void mirrotOfBinaryTreePreorder2(BinaryTreeNode root)
    {
        if (root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root != null && !stack.isEmpty())
        {
            while (root != null)
            {
                if (root.rightChild != null || root.leftChild != null)
                {
                    BinaryTreeNode tmp = root.leftChild;
                    root.leftChild = root.rightChild;
                    root.rightChild = tmp;
                }
                stack.push(root);
                root = root.leftChild;
            }
            if (!stack.isEmpty())
            {
                root = stack.pop();
                root = root.rightChild;
            }
        }
    }

}
