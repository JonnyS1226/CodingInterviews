package chapter4;

/**
 * 序列化二叉树
 *      两个函数分别实现序列化和反序列化
 */
public class T37_SerializeBinaryTrees {
    public static class BinaryTreeNode{
        BinaryTreeNode left;
        BinaryTreeNode right;
        int val;
        public BinaryTreeNode(int x)
        {
            this.val = x;
        }
    }

    /**
     * 正常情况下，需要两个遍历序列才能确定一棵二叉树，但是如果将null也考虑进去用一个字符表示，则只需要一个
     * 选择先序序列，对于空指针使用'$'表示
     * @param root
     */
    public static void serialize(BinaryTreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        if (root == null)
        {
            sb.append('$');
            return;
        }
        sb.append(root.val).append(" ");
        serialize(root.left);
        serialize(root.right);
    }

    /**
     * 由含null的先序遍历序列构造二叉树
     * @param sb    序列
     * @param index 序列的索引，从0开始
     */
    public static BinaryTreeNode deserialize(StringBuilder sb, int index)
    {
        if (sb.length() == 0) return null;
        if (sb.charAt(index) == '$')
        {
            return null;
        }
        BinaryTreeNode curr = new BinaryTreeNode(Integer.parseInt(String.valueOf(sb.charAt(index))));
        curr.left = deserialize(sb, index + 1);
        curr.right = deserialize(sb, index + 1);
        return curr;
    }



}
