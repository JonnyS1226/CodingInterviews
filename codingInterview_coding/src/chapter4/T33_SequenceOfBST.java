package chapter4;

/**
 * 二叉搜索树的后序遍历序列
 *      输入一个整数数组，判断该数组是不是某二叉搜索数的后序遍历结果
 */
public class T33_SequenceOfBST {

    /**
     * 方法1   思想：使用递归
     * 后序遍历，最后一个元素是根节点，要满足左子树小于根，右子树大于根。
     * 从左边开始，找到第一个大于根的，从这开始就是右子树，但若右子树中发现有小于根的 很显然就不符合了
     * 然后递归左子树和右子树
     * @param array
     * @return
     */
    public static boolean isSequence(int[] array, int start, int length)
    {
        if (array == null) return false;
        int rootVal = array[length - 1];
        //左子树小于根
        int i = start;
        for (i = start; i < length - 1; i++)
        {
            if (array[i] > rootVal)
            {
                break;
            }
        }
        //右子树大于根
        int j = i;
        for (j = i; j < length - 1; j++) {
            if (array[j] < rootVal)
            {
                return false;
            }
        }
        //递归判断
        boolean left = true;
        if (i > 0)
            left = isSequence(array, 0, i);
        boolean right = true;
        if (i < length - 1)
            right = isSequence(array, i, length - i - 1);
        return (left && right);
    }

    /**
     * 方法2
     * @param seq
     * @param begin
     * @param end
     * @return
     */
    public static boolean isSearchBST(int[] seq, int begin, int end) {
        // begin比end大说明上层结点没有左子树或者右子树，begin == end说明该本层结点没有子树，无需比较了
        // 这两种情况都应该返回true
        if (begin >= end) return true;

        int rootVal = seq[end];
        int i = begin;
        // 左子树都比root小
        while (i < end && seq[i] < rootVal) {
            i++;
        }
        // 找到了左右子树的分界，[begin, boundary-1]为左子树，[boundary, end -1]是右子树
        int boundary = i;
        while (i < end) {
            // 右子树中还存在比root小的说明不是二叉搜索树
            if (seq[i] < rootVal) return false;
            i++;
        }
        // 左右子树必须同时都是二叉搜索树
        return isSearchBST(seq, begin, boundary - 1) && isSearchBST(seq, boundary, end - 1);
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isSearchBST(sequence, 0, sequence.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9, 11, 7, 10, 8};
        System.out.println(isSequence(array, 0, array.length));
        System.out.println(verifySquenceOfBST(array));
    }
}
