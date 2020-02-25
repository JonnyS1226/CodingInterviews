package chapter6;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *      从扑克牌中抽5张牌，判断是不是一个顺子
 *              A为1，J为11，Q为12，K为13，大小王视作任意数字
 */
public class T61_ContinuousCards {
    /**
     * 解决：
     *      1. 将字符和数字对应转换，大小王可以作为0  (这一步是用户输入时自定，下面没有给出)
     *      2. 进行排序
     *      3. 判断排序后相邻数字间的空缺的个数是否等于“癞子”的个数，不等则不成顺子
     *      4. 注意一旦出现对子，就不可能是顺子
     */
    public boolean isContinuous(int[] numbers)
    {
        if (numbers == null) return false;
        Arrays.sort(numbers);
        int numberOf0 = 0;
        int numberOfGap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) numberOf0++;
        }

        //求gap
        int start = numberOf0;
        int end = start + 1;
        while (start < end)
        {
            if (numbers[start] == numbers[end])
                return false;
            numberOfGap += numbers[end] - numbers[start] - 1;
            start = end;
            end++;
        }
        return (numberOf0 >= numberOfGap)? true : false;

    }


}
