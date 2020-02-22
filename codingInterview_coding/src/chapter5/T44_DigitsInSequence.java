package chapter5;

/**
 * 数字序列中某一位的数字
 *      数字以01234567891011121314... 的格式序列化到一个字符序列种。设计一个函数，求出任意第n位的数字（位数从0开始计数）
 */
public class T44_DigitsInSequence {
    /**
     * 方法1：蛮力枚举法
     * 输入n。从0开始枚举数字，例如枚举到数字k，先判断k是几位数，然后与一个位数累加器作和，判断累加后的值与n的大小，直到相等则返回这个数k
     */

    /**
     * 方法2：找规律
     * 基本思想是求第n位时，不从第0位开始求解，而是跳过前面的若干位，提高效率
     * 如1001位，可以跳过10位一位数，可以跳过2*90位两位数，三位数一共有3*900，故1001位一定在三位数范围内找，且是三位数中881位
     * 881 = 3 * 270 + 1，故881是三位数中第270位的中间一位，即370的中间一位，即7
     */
    public static int digitAtIndex(int n)
    {
        if (n < 0) return -1;
        //位数，如一位数，两位数....
        int digits = 1;
        while (true)
        {
            int preNumber = countPresequence(digits);
            if (n < preNumber)
            {
                return calculateCore(n, digits);
            }
            n -= preNumber;
            digits++;
        }
    }

    //计算m位的数字在序列中一共有多少位，如m=2，则返回2*90=180
    public static int countPresequence(int digits)
    {
        if (digits == 1) return 10;
        int start = beginNum(digits);
        int end = beginNum(digits + 1) -1;
        return digits * (end - start + 1);
    }

    //找到了位于哪个范围(几位数)后，具体的计算第n位的数字的值
    public static int calculateCore(int index, int digits)
    {
        int beginNumber = beginNum(digits);
        int quotient = index / digits;
        int remainder = index % digits;
        int resultNumber = beginNumber + quotient;
        for (int i = 0; i < digits - remainder - 1; i++) {
            resultNumber /= 10;
        }
        return resultNumber % 10;
    }
    //得到n位数的开始的那个数，如n=3，则返回100
    public static int beginNum(int digits)
    {
        if (digits == 1) return 0;
        return (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
    }


}
