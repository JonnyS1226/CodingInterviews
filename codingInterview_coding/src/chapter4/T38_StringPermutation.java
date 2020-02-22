package chapter4;

import java.util.ArrayList;

/**
 * 字符串的全排列
 *      如输入abc，则输出abc，acb，bac，bca，cab，cba
 */
public class T38_StringPermutation {

    /**
     * 全排列问题
     * 求全排列，把第一位和后面各位交换，得到了第一位的所有情况
     * 后面每位都是如此，故使用递归
     * 本质其实就是回溯法
     * @param str
     * @return
     */
    public static ArrayList<String> permutation(String str)
    {
        ArrayList<String> rs = new ArrayList<>();
        if (str == null) return rs;
        permutationCore(str.toCharArray(), 0, rs);
        return rs;
    }

    public static void swap(char[] chars, int i, int j)
    {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void permutationCore(char[] chars, int index, ArrayList<String> rs)
    {
        if (index == chars.length - 1)
        {
            String s = String.valueOf(chars);
            if (!rs.contains(s))
            {
                rs.add(s);
                return;
            }
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutationCore(chars, index + 1, rs);
            swap(chars, index, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }
}
