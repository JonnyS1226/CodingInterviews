package chapter3;

/**
 * 正则表达式匹配
 *      实现一个函数来匹配包含.和*的正则表达式，.表示任意一个字符，*表示它前面的字符可以出现任意次（包括0次）---> 如b* 表示b可以出现任意次
 */
public class T19_RegularExpressionMatching {
    //可以运用形式语言与自动机理论来解决
    //字符串匹配，如果发现.，则直接再匹配下一个字符，如果发现*，则前一个字符递归调用，重复匹配

    public static boolean regularExpressionMatch(char[] str, char[] pattern){
        if (str == null || pattern == null)
        {
            return false;
        }
        return regularExpressionMatchCore(str, pattern, 0, 0);
    }

    /**
     * 正则匹配的核心函数（递归）
     * @param str   待匹配的字符串
     * @param pattern   给出的模式串
     * @param indexS    待匹配字符串指针（索引）
     * @param indexP    给出的模式串指针（索引）
     * @return
     */
    public static boolean regularExpressionMatchCore(char[] str, char[] pattern, int indexS, int indexP){
        if (indexS == str.length && indexP == pattern.length)
        {
            return true;
        }
        //模式串到头了但待匹配串没有到头，则一定不匹配；反之不一定，因为可能最后一个是*
        if (indexS != str.length && indexP == pattern.length)
        {
            return false;
        }

        // 如果发现有*
        if (indexP + 1 != pattern.length && pattern[indexP + 1] == '*')
        {
            //* 号前面是匹配的情况下
            if ((indexS < str.length && str[indexS] == pattern[indexP]) || (pattern[indexP]== '.' && indexS < str.length)){
                //根据自动机碰到*的模式串三种选择：保持原地，前进，忽视
                return regularExpressionMatchCore(str, pattern, indexS + 1, indexP)
                        || regularExpressionMatchCore(str, pattern, indexS + 1, indexP + 2)
                        || regularExpressionMatchCore(str, pattern, indexS, indexP + 2);
            }
            // * 号前面不等或者不是'.'，相当于忽略这个字符向后匹配
            else {
                return regularExpressionMatchCore(str, pattern, indexS, indexP + 2);
            }
        }
        //如果发现有.或者两者所指向的字符相同，则可以去匹配下一个字符
        if ((indexS != str.length && pattern[indexP] == str[indexS]) || (pattern[indexP] == '.' && indexS != str.length))
        {
            return regularExpressionMatchCore(str, pattern, indexS + 1, indexP + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String string1 = "bcaaad";
        String string2 = "bab";
        String string3 = "bbcaio";
        String stringPattern = "ba*bcaio";
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();
        char[] str3 = string3.toCharArray();
        char[] pattern = stringPattern.toCharArray();
        System.out.println(regularExpressionMatch(str1, pattern));
        System.out.println(regularExpressionMatch(str2, pattern));
        System.out.println(regularExpressionMatch(str3, pattern));
    }
}
