package chapter5;

/**
 * 礼物的最大价值
 *      m*n棋盘，每一格都有一个礼物，可以从棋盘左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角
 *      求最多能拿到多少价值的礼物
 */
public class T47_MaxValueOfGifts {

    /**
     * 本质就是求从左上到右下有多少种走法，是一个典型的dp问题
     */

    public static int maxValue(int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];
        if(m == 1 || n == 1) return 1;
        for(int i = 0; i <= n; i++)
        {
            dp[1][i] = 1;
        }
        for(int i = 0; i <= m; i++)
        {
            dp[i][1] = 1;
        }
        for(int i = 2; i <= m; i++)
        {
            for(int j = 2; j <= n; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}

