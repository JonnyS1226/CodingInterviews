package chapter2;

/**
 * 15_二进制中1的个数
 *      输入一个整数，输出该数二进制表示中1的个数
 */
public class T15_NumberOf1InBinary {

    /**
     * 法1：每次数字算术右移，但是对于负数会造成死循环。但可以改用逻辑右移
     * @param number
     * @return
     */
    public static int numberOf1MethodOne(int number)
    {
        int cnt = 0;
        while (number != 0)
        {
            if ((number & 1) != 0)
            {
                cnt++;
            }
            //使用算术右移，则负数情况会死循环
//            number = number >> 1;
            //下面使用逻辑右移
            number = number >>> 1;
        }
        return cnt;
    }

    /**
     * 方法1不可行的原因是负数算术右移会导致高位添0而死循环，若改为逻辑右移是可行的
     * 方法2：改成使除数不断左移
     * @param n
     * @return
     */
    public static int numberOf1MethodTwo(int n)
    {
        int cnt = 0;
        int flag = 1;
        while (flag != 0)
        {
            if ((n & flag) != 0)
            {
                cnt++;
            }
            flag = flag << 1;
        }
        return cnt;
    }

    /**
     * 前两种方法对于32位整数都需要32次运算，而法3可以提高效率
     * 方法3:
     *      一个数n减去1，在二进制中会将最右边的1变成0，且这个1后面的0全变成1.
     *      且将这个数与原数作与，则就能将原数的最右边的1变成0
     *      于是，在数不为0的情况下，有多少次减法即多少个1
     * @param n
     * @return
     */
    public static int numberOf1MethodThree(int n)
    {
        int cnt = 0;
        while (n != 0)
        {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }

    /*
     * 15_2: 用一条语句判断一个整数是不是2的倍数
     *      如果是2的整数次方，则二进制中一定只有一位是1
     */
    public static boolean isExponentOf2(int n)
    {
        return numberOf1MethodThree(n) == 1;
    }

    /*
     * 15_3: 输入两个整数m和n，计算需要改变m的二进制中多少位，才能得到n
     *      异或为1表示两个数该位不同，所以只要返回异或结果中1的个数即可
     */
    public static int bitChange(int m, int n)
    {
        return numberOf1MethodThree(m ^ n);
    }

    public static void main(String[] args) {
        System.out.println(numberOf1MethodOne(9));
        System.out.println(numberOf1MethodTwo(9));
        System.out.println(numberOf1MethodThree(9));
        System.out.println(numberOf1MethodOne(15));
        System.out.println(numberOf1MethodTwo(15));
        System.out.println(numberOf1MethodThree(15));
        System.out.println(numberOf1MethodOne(-4));
        System.out.println(numberOf1MethodTwo(-4));
        System.out.println(numberOf1MethodThree(-4));
        System.out.println(numberOf1MethodOne(1));
        System.out.println(numberOf1MethodTwo(1));
        System.out.println(numberOf1MethodThree(1));
    }
}





