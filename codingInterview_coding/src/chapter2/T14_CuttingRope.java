package chapter2;


/**
 * 14_剪绳子问题
 *      长度为n的绳子，剪成m段（m，n都是整数且都大于1），求剪出来各段绳子的长度的乘积最大是多少？（以及对应的剪绳子法）
 */
public class T14_CuttingRope {
    //方法1. 动态规划     O(n^2)
    /**
     * 动态规划实现，思想如下：
     * f(n)表示长度为n的切割各段乘积最大值，f(n)=max{f(i)*f(n-i)}
     * @param length 绳子长度
     * @return
     */
    public static int maxProductUsingDp(int length){
        int maxProduct = 1;
        //由于题意表示必须切，故长度小于2就返回0
        if (length < 2)
        {
            return 0;
        }
        if (length == 2)
        {
            return 1;
        }
        if (length == 3)
        {
            return 2;
        }
        int[] resultDp = new int[length + 1];
        //以下是数组初值，不是f(1)-f(4)，而是长度，当n>4时，开始使用递归式
        resultDp[0] = 0;
        resultDp[1] = 1;
        resultDp[2] = 2;
        resultDp[3] = 3;
        for (int i = 4; i <= length; i++) {
            int tmpMax = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = resultDp[i - j] * resultDp[j];
                if (tmpMax < product)
                {
                    tmpMax = product;
                }
                resultDp[i] = tmpMax;
            }
        }
        int max = resultDp[length];
        return max;
    }


    //方法2. 贪婪思想     O(n)
    /**
     * 由数学规律可知，a+b=n，当a和b越接近时ab乘积越大。当n>=5时，为了乘数接近，故分为若干个2和若干个3的组合（可以为0个2或0个3）
     * 而又由于n>=5时，3（n-3）>2(n-2)，故尽量要分出3。但当最终剩下4时，要选择切成2*2 而非3*1
     * n=1，2，3单独分析，n=4时也可以单独分析
     * @param length 绳子长度
     * @return
     */
    public static int maxProductUsingGreedy(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;
        // 如果剩下长度为4,切成3的个数要减1
        if (length - timesOf3 * 3 == 1)
            timesOf3--;
        // 下面是切成2的个数
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }

    public static void main(String[] args) {
        System.out.println(maxProductUsingDp(1));
        System.out.println(maxProductUsingDp(3));
        System.out.println(maxProductUsingDp(5));
        System.out.println(maxProductUsingDp(8));
        System.out.println(maxProductUsingDp(17));
        System.out.println(maxProductUsingGreedy(1));
        System.out.println(maxProductUsingGreedy(3));
        System.out.println(maxProductUsingGreedy(5));
        System.out.println(maxProductUsingGreedy(8));
        System.out.println(maxProductUsingGreedy(17));
    }
}
