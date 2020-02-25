package chapter6;

/**
 * n个骰子的点数
 *      n个骰子扔在地上，所有骰子朝上一面的点数和为s。输入n，求s的所有可能值的出现的概率
 */
public class T60_DicesProbability {
    /**
     * 使用动态规划的思想
     * dp[n][s]表示n个骰子，点数和为s的情况的次数。总次数是6^n
     *  for (第n枚骰子的点数 i = 1; i <= 6; i ++) {
     *     dp[n][s] += dp[n-1][s - i]; }
     */

    public double[] getProbability(int n, int s)
    {
        int[][] dp = new int[n + 1][s + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int currDices = 1; currDices <= 6; currDices++) {
                    if (j - currDices <= 0)
                        break;
                    dp[i][j] += dp[i - 1][j - currDices];
                }
            }
        }

        //输出结果
        double[] ans = new double[5 * n + 1];
        double allNum = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = (double) dp[n][i] / allNum;
        }
        return ans;
    }



}
