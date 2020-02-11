package chapter3;

/**
 * 输入n，打印从1到最大的n位数。     需要考虑大数问题
 */
public class T17_Print1ToMaxOfNDigits {

    /**
     * 考虑到大数问题，一般都选择用字符串或字符数组来模拟
     * 法1： 用字符串模拟加法，但比较繁琐
     * 法2： n位字符串，初始每位都记为0，按照个位，十位...进行全排列变化各位，最后输出时从第一个非0开始输出
     * @param n
     */
    public static void print1ToNDigits(int n)
    {
        if (n <= 0)
        {
            return;
        }
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < n; i++) {
            number.append('0');
        }
        print1ToNDigitsRecursive(number, number.length(), 0);
    }

    //核心递归
    public static void print1ToNDigitsRecursive(StringBuilder number, int length, int index){
        if (index == length)
        {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number.setCharAt(index, (char) (i + '0'));
            print1ToNDigitsRecursive(number, length, index + 1);
        }
    }

    // 输出数字
    public static void printNumber(StringBuilder number)
    {
        int start = number.length();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0')
            {
                start = i;
                break;
            }
        }
        if (start < number.length())
        {
            System.out.print(number.substring(start) + " ");
        }
    }

    public static void main(String[] args) {
        print1ToNDigits(3);
        System.out.println();
        print1ToNDigits(2);
        System.out.println();
        print1ToNDigits(1);
    }
}
