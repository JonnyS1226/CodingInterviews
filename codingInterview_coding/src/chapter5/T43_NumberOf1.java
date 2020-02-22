package chapter5;

/**
 * 1出现的次数
 *      输入一个整数n，求1-n这n个数的十进制表示中1出现的次数
 */
public class T43_NumberOf1 {

    /**
     * 方法1：使用蛮力法遍历
     */

    /**
     * 方法2：
     * 思想：
     *      比如有n位，本质上就是求这n位，每位上可出现1的次数的总和
     * 案例：
     *      如 n=132_78，若_=1：则这一位出现1的次数总和为：132*100 + 1 + 78  (0-131 、0-77)
     *                若_=0：则这一位出现1的次数和为：132*100  (0-131)
     *                若_>1：则这一位出现1的次数和为：133*100  (0-132)
     *      这样的规律来自于：比如n=132178，当前三位取（0-131）时，_可以取1，此时最后两位可以取100种（0-99），
     *                                   而前三位取到132，最后两位取（0-77）.故最终如公式所示
     * 而对于其他位，使用递归或迭代即可
     * 这个规律可以扩充到任意数x
     */
    public static int numberOf1(int n)
    {
        if (n < 0) return -1;
        int cnt = 0;
        //当前位:取值1，10，100...
        int currDigit = 1;
        int current = 0, before = 0, after = 0;
        while ((n / currDigit) != 0)
        {
            current = (n / currDigit) % 10;
            before = n / (currDigit * 10);
            after = n - (n / currDigit) * currDigit;
            if (current == 1)
                cnt += before * currDigit + 1 + after;
            else if (current > 1)
                cnt += (before + 1) * currDigit;
            else
                cnt += before * currDigit;
            currDigit *= 10;
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(numberOf1(12));
    }
}
