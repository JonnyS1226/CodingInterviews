package chapter6;

/**
 * 股票的最佳利润
 *      即最大子数组问题
 */
public class T63_MaximalProfit {
    //下面的数组也可以优化掉
    public static int maxProfit(int[] array)
    {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxSum = dp[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] < 0)
            {
                dp[i] = array[i];
            }
            else {
                dp[i] = dp[i - 1] + array[i];
            }
            if (maxSum < dp[i])
                maxSum = dp[i];
        }
        return maxSum;
    }
}
