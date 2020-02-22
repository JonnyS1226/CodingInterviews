package chapter4;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *          输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
 *          从根节点一直向下直到叶节点 所经过的节点称为一条路径
 */
public class T34_PathInTree {
    public static class BinaryTreeNode{
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int val;
    }

    /**
     * 思想：按照先序遍历
     * 本质就是按照先序遍历的思想，先遍历到叶子，然后有一个模拟的栈来表示根到该叶子路径上节点的和
     * 判断是否满足等于target，满足则就是一种结果
     * 不满足则将这个叶子出栈，回到上级，找下一个叶子
     * @param target
     * @param root
     */
    public static ArrayList<ArrayList<Integer>> findPath(int target, BinaryTreeNode root)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        findPathCore(root, target, path, result);
        return result;
    }

    public static void findPathCore(BinaryTreeNode root, int currentVal, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result)
    {
        if (root == null)
        {
            return;
        }
        //模拟将当前节点入栈
        path.add(root.val);
        currentVal -= root.val;
        //当遍历到叶子节点，开始判定是否符合target
        if (root.leftChild == null && root.rightChild == null)
        {
            if (currentVal == 0) result.add(new ArrayList<>(path));
        }
        if (root.leftChild != null) findPathCore(root.leftChild, currentVal, path, result);
        if (root.rightChild != null) findPathCore(root.rightChild, currentVal, path, result);
        //当都不符合，就将该节点出栈，回到上层父亲
        path.remove(path.size() - 1);
        currentVal += root.val;





    }


}
