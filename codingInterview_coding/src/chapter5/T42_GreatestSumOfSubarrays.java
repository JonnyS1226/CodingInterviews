package chapter5;

/**
 * 连续子数组的最大和问题
 */
public class T42_GreatestSumOfSubarrays {

    /**
     * 使用动态规划的思想去解
     * dp[i]表示前i个数情况下，连续子数组的最大和的值
     * dp[i] = max{ dp[i-1]+array[i], array[i] }
     *
     * 最终只要求max{dp[i]}, i from 0 to length-1
     */

    public static int solve(int[] array)
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
