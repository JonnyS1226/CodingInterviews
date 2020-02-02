package chapter2;

/**
 * 将空格替换为%20
 */
public class T05_1_ReplaceSpaces {

    //方法1. 从前往后替换，同时替换一个空格后面的字符要后移两位 O(n^2)

    //方法2. O(n)
    //先遍历找空格次数，同时得到替换后的总长度
    // 从后往前替换，p1，p2两个指针，分别指向原字符串末尾和替换后的字符串末尾
    //p1前移，并逐个复制到p2指针处并且p2前移，当p1碰到空格，则p2处复制的值为%20
    public static StringBuilder replaceSpaces(StringBuilder stringBuilder){
        if (stringBuilder.length() == 0)
        {
            return null;
        }
        int originalLength = stringBuilder.length();
        int numOfBlank = 0;
        int i = 0;
        while (i < originalLength)
        {
            if (stringBuilder.charAt(i) == ' ')
            {
                numOfBlank++;
            }
            i++;
        }
        int newLength = originalLength + numOfBlank * 2;
        int indexOfP1 = originalLength - 1;
        int indexOfP2 = newLength - 1;

        //补充stringBuilder，也可使用for循环
        stringBuilder.append(" ".repeat(Math.max(0, indexOfP2 - indexOfP1)));
        while (indexOfP1 >= 0 && indexOfP2 > indexOfP1)
        {
            if (stringBuilder.charAt(indexOfP1) == ' ')
            {
                stringBuilder.setCharAt(indexOfP2--, '0');
                stringBuilder.setCharAt(indexOfP2--, '2');
                stringBuilder.setCharAt(indexOfP2--, '%');
            }
            else
            {
                stringBuilder.setCharAt(indexOfP2--, stringBuilder.charAt(indexOfP1));
            }
            indexOfP1--;
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        String str = "how are you fine thank you";
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(replaceSpaces(stringBuilder).toString());
    }
}
