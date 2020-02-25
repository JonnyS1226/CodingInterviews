package chapter6;

/**
 * 数组中数字出现的次数
 *      题目一：求数组中只出现一次的两个数字
 */
public class T56_NumbersAppearOnce {

    /**
     * 假如题目是只有一个数字出现一次，其他出现两次：
     *      使用异或，每个数作异或，根据异或性质相同为0不同为1，最后得到的值就是只出现一次的那个数字
     * 而本题只要想办法将数组分成两组，每组用上述方法就可以求出答案
     * 如何分组：
     *      1. 两个只出现一次的要分开  2. 相同的数字要在一组
     *      将所有数异或，得到一个值，其中一定有一个1（因为全0就意味着两两都相等）
     *      于是按照那一位是否是1来分组，这种分组方式很显然满足上述两个要求
     */
    public static int[] numbersAppearOnce(int[] array)
    {
        int xor = 0;
        for (int i : array) {
            xor ^= i;
        }
        //下面得到结果中的最右边的1，采用如下方法，也可采用移位
        int val = xor & (-xor);
        int[] res = new int[2];
        for (int num : array) {
            if ((num & val) == 1)
            {
                res[0] ^= num;
            }
            else
            {
                res[1] ^= num;
            }
        }
        return res;
    }


    /**
     * 56-2：数组中唯一只出现一次的数字
     *      数组中 有一个数字只出现一次，其他数字都出现3次，求那个只出现一次的
     *
     * 解法：延续位运算思想
     *      假如没有这个数字，即每个数字出现3次，那么数字的二进制表示中，每一位加起来最后一定能整除于3
     *      现在有了这个数字，只要看最后哪些位没有整除于3，这些位就是取的1，其他位取的0
     */

    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int num : nums){
                if(((1 << i) & num) > 0){
                    count++;
                }
            }
            if(count % 3 == 1){
                ans += (1 << i);
            }
        }
        return ans;
    }

}
