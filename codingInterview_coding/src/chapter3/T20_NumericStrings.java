package chapter3;

/**
 * 表示数值的字符串
 *      实现一个函数来判断一个字符串是否表示数值（包括整数和小数）
 */
public class T20_NumericStrings {

    //字符串指针
    private static int index = 0;
    /**
     * 方法1：
     * 同样使用形式语言与自动机理论来执行，表示这个文法的模式是A.[.[B]][e|E C]或.B[e|E C]，其中A,C是可带符号整数，B是无符号整数
     * 这里注意，题目给出：.133这样的，233.这样的都可以，故B不是必须
     * @param str   待匹配字符串
     * @return
     */
    public static boolean isNumericStrings(char[] str)
    {
        if (str == null)
        {
            return false;
        }
        //扫描A
        boolean numeric = scanSignedInteger(str);
        //扫描.
        if (index < str.length && str[index] == '.')
        {
            index++;
            //扫描B
            numeric = scanUnsignedInteget(str);
        }
        //扫描e|E
        if (index < str.length && (str[index] == 'e' | str[index] == 'E'))
        {
            index++;
            //扫描C
            numeric = scanSignedInteger(str);
        }
        return numeric && index == str.length;
    }

    /**
     * 搜索可带符号整数A和C
     * @param str
     * @return
     */
    public static boolean scanSignedInteger(char[] str)
    {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
        {
            index++;
        }
        return scanUnsignedInteget(str);
    }

    /**
     * 搜索无符号整数B
     * @param str
     * @return
     */
    public static boolean scanUnsignedInteget(char[] str)
    {
        int saveIndex = index;
        while (index < str.length && (str[index] >= '0' && str[index] <= '9'))
        {
            index++;
        }
        return index > saveIndex;
    }


    /**
     * 方法2：是用自带的正则匹配
     * []  ： 字符集合
     * ()  ： 分组，为了让表达式更清晰
     * ?   ： 重复 0 ~ 1 次
     * +   ： 重复 1 ~ n 次
     * *   ： 重复 0 ~ n 次
     * .   ： 任意字符
     * \\. ： 转义后的 .
     * \\d ： 任意数字
     * @param str
     * @return
     */
    public static boolean isNumericStringsRe(char[] str)
    {
        if (str == null)
        {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }



    public static void main(String[] args) {
        String string = "-123";
        char[] str = string.toCharArray();
        System.out.println(isNumericStrings(str));
        System.out.println(isNumericStringsRe(str));
    }
}
