package chapter6;

import java.util.Stack;

public class T58_ReverseWordsInSentence {

    /**
     * 59——1：翻转单词顺序
     *          输入一个英文句子，翻转句子中单词的顺序，若有标点符号，按普通字母处理
     * 解决方式：
     *          碰到一个空格，他后面的直到下一个空格之间的就是一个单词，作为整体放入栈中即可
     */
    public static String reverseWords(String str)
    {
        if (str == null) return null;
        char[] chars = str.toCharArray();

        Stack<String> stack = new Stack<>();
        for (int index = 0; index < str.length(); index++)
        {
            if (chars[index] == ' ')
            {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (index != str.length() && chars[index] != ' ')
            {
                sb.append(chars[index++]);
            }
            stack.push(sb.toString());
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
        {
            ans.append(stack.pop());
            ans.append(' ');
        }
        return ans.toString().trim();
    }


    /**
     * 59-2:左旋转字符串
     *      实现字符串左旋功能，如输入abcdefg和2，则输出cdefgab
     * 解决：
     *      使用substring
     */
    public static String reverseLeftWords(String s, int n) {
        if(s == null || s.length() < 2 || n >= s.length())
            return s;
        return s.substring(n)+s.substring(0,n);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue!"));
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
