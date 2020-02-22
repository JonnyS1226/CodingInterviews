package chapter5;

/**
 * 丑数
 *      只包含因子2，3，5的数称为丑数。习惯上把1作为第一个丑数。求从小到大的顺序的第n个丑数
 */
public class T49_UglyNumber {

    /**
     * 三指针+dp
     * 记dp[i]表示第i个丑数
     * 可以看到，所有的丑数都是基于前面的丑数*2，*3，*5得到的
     * 所以dp[i]应该是前面的丑数*2，*3，*5三个数中满足1.最小，2.大于原先的最大丑数
     * 所以定三个指针index2，index3，index5，都从1开始，分别*2，*3，*5，然后取三者中最小的那个作为下一个丑数
     * 并且成功下一个丑数的“基数”++
     */
    public static int getUglyNumber(int n)
    {
        if (n < 1) return -1;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[index2] * 2, dp[index3] * 3), dp[index5] * 5);
            if (dp[index2] * 2 == dp[i]) index2++;
            if (dp[index3] * 3 == dp[i]) index3++;
            if (dp[index5] * 5 == dp[i]) index5++;
        }
        return dp[n - 1];
    }


}
