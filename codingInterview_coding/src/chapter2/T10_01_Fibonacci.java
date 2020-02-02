package chapter2;

import java.util.Scanner;

/**
 * 求斐波那契数列的第n项
 */
public class T10_01_Fibonacci {

    //方法1. 低效的递归法O(2^n)
    public static long fibonacci(int n)
    {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //方法2. 上述方法中，递归计算的重复项太多，下面自底向上  O(n)
    public static long advancedFibonacci(int n)
    {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        //类似于f(n-1)和f(n-2)
        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
    //方法3 基于数学公式，此处省略

    public static void main(String[] args) {
        System.out.println("输入n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a = System.currentTimeMillis();
//        System.out.println("递归法斐波那契第n项：" + fibonacci(n));
//        System.out.println("执行时间为：" + (System.currentTimeMillis() - a) + "ms");
        a = System.currentTimeMillis();
        System.out.println("自底向上斐波那契第n项：" + advancedFibonacci(n));
        System.out.println("执行时间为：" + (System.currentTimeMillis() - a) + "ms");
    }
}

/**
 * 青蛙跳台阶问题
 *      一只青蛙一次跳上1级台阶，也可以跳上2级台阶，求该青蛙跳上一个n级台阶共有几种跳法
 */
// 记跳n级台阶有f(n)种
// 跳一级台阶只有1种，跳二级台阶有两种，
// 跳>2级台阶时，第一次可以跳一级，则是f(n-1)。第一次若跳两级，则f(n-2)。故一共有f(n-1)+f(n-2)种

/**
 * 青蛙跳台阶进阶版：思路与青蛙跳台阶一样。第一次跳1级：f(n-1) ..... 最后再加上f(0)=1即一下跳上去。  f(n)=f(n-1)+f(n-2)+...+f(1)+1，由数学归纳法即可
 */

/**
 * 矩形覆盖问题
 *      用8个2*1的小矩形横着或竖着去覆盖一个2*8的大矩形，有多少种方法
 */
// 记总共f(8)种
// 左边先竖着放，则还有f(7)种
// 左边先横着放，则还有f(6)种
// 故同样是一个斐波那契问题： f(8) = f(7) + f(6)
