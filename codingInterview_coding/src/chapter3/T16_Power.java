package chapter3;

/**
 * 16_数值的整数次方
 *      实现函数double Power(double base, int exponent)，不考虑大数问题，不使用库函数
 */
public class T16_Power {

    /**
     * 法1：
     * 常规方法，注意要考虑指数正、负、0三种情况
     * @param base  底数
     * @param exponent  指数
     * @return
     */
    public static double power(double base, int exponent)
    {
        // 下面的顺序保证0^0=1，0^t=0, t^0=1，1^t=1
        if (exponent == 0 || base == 1)
        {
            return 1;
        }
        if (base == 0)
        {
            return 0;
        }
        double result = 1.0;
        int tmpExponent = Math.abs(exponent);
        for (int i = 0; i < tmpExponent; i++) {
            result *= base;
        }
        return exponent < 0 ? 1 / result : result;
    }

    /**
     * 法2：
     * 类似于分治的思想，减小问题的规模
     * m^n，若是偶数次幂，则等于m^(n/2) * m^(n/2)
     * 若是奇数次幂，则等于m^(n-1/2) * m^(n-1/2) * m
     * @param base
     * @param exponent
     * @return
     */
    //递归版本
    public static double advancedPowerRecursiveCore(double base, int exponent)
    {
        if (exponent == 0 || base == 1)
        {
            return 1.0;
        }
        if (base == 0)
        {
            return 0.0;
        }
        //递归出口
        if (exponent == 1)
        {
            return base;
        }
        double result = advancedPowerRecursiveCore(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) != 0)
        {
            result *= base;
        }
        return result;
    }
    public static double advancedPowerRecursive(double base, int exponent)
    {
        int absExponent = Math.abs(exponent);
        double result = advancedPowerRecursiveCore(base, absExponent);
        return exponent < 0 ? 1 / result : result;
    }

    //非递归版本
    public static double advancedPowerNoRecursive(double base, int exponent)
    {
        if (exponent == 0 || base == 1)
        {
            return 1.0;
        }
        if (base == 0)
        {
            return 0.0;
        }
        if (exponent == 1)
        {
            return base;
        }
        double result = base;
        int absExponent = Math.abs(exponent);
        while (absExponent != 0)
        {
            if ((absExponent & 1) == 0)
            {
                result *= base;
            }
            base *= base;
            absExponent = absExponent >> 1;
        }
        return exponent < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(power(1.1, 2));
        System.out.println(power(3.0, 0));
        System.out.println(power(0.5, -1));
        System.out.println(power(0.0, 0));
        System.out.println(power(2.0, -2));

        System.out.println(advancedPowerRecursive(1.1, 2));
        System.out.println(advancedPowerRecursive(3.0, 0));
        System.out.println(advancedPowerRecursive(0.5, -1));
        System.out.println(advancedPowerRecursive(0.0, 0));
        System.out.println(advancedPowerRecursive(2.0, -2));

        System.out.println(advancedPowerNoRecursive(1.1, 2));
        System.out.println(advancedPowerNoRecursive(3.0, 0));
        System.out.println(advancedPowerNoRecursive(0.5, -1));
        System.out.println(advancedPowerNoRecursive(0.0, 0));
        System.out.println(advancedPowerNoRecursive(2.0, -2));
    }

}
