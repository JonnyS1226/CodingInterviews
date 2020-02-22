package chapter5;

/**
 * 把数字翻译成字符串
 *      0翻译成a，1翻译成b.... 25翻译成z
 *      但一串数字可能有多种翻译方法，实现一个函数，计算一串数字有多少种不同的翻译方法？
 */
public class T46_TranslateNumbersToStrings {

    /**
     * 动态规划或回溯法
     * 此处使用动态规划：
     *      记f(i) 表示前i位，翻译方法数
     *      由于一次可以翻译一位或者两位，所以有f(i) = f(i-1) + f(i-2)
     *      但是需要注意的是，取到f(i-1)和f(i-2)对于第i位数字或者第i-1，i位数字是有要求的
     * @param number
     * @return
     */
    public int translateNum(int number) {
        if (number < 0) return 0;
        char[] num = String.valueOf(number).toCharArray();
        int[] dp = new int[num.length];

        dp[0] = 1;
        if(num.length == 1) return dp[0];

        int firstTwo = 10 * (num[0] - '0') + (num[1] - '0');
        if(firstTwo >= 10 && firstTwo <= 25) dp[1] = 2;
        else dp[1] = 1;

        for (int i = 2; i < num.length; i++) {
            if (num[i] >= '0' && num[i] <= '9')
            {
                dp[i] = dp[i] + dp[i - 1];
            }
            int twoNum = 10 * (num[i - 1] - '0') + (num[i] - '0');
            if (twoNum <= 25 && twoNum >= 10)
            {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[num.length - 1];
    }



}
