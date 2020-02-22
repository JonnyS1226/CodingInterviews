package chapter5;

import java.util.Arrays;
import java.util.Stack;

/**
 * 数组中出现次数超过数组长度一半的数字
 */
public class T39_MoreThanHalfNumber {

    /**
     * 方法一：使用快排的思想延申
     * 随机选择一个数，让比他小的位于其左边，比他大的位于其右边
     * 但是这一步结束后分成左右两块，不都进行递归，而是根据这个数的位置和中间位置的关系，选择其中一个来执行.
     * 假设若存在一个数出现次数超过一半，那么数组内的排序位置的中位位置上的那个数一定是这个数
     */

    //快排的切割函数
    public static int partition(int[] array, int start, int end)
    {
        int i = start;
        int j = end;
        int pivot = array[i];
        while (i < j)
        {
            while (i < j && array[j] >= pivot)
                j--;
            swap(array, i, j);
            while (i < j && array[i] <= pivot)
                i++;
            swap(array, i, j);
        }
        return j;
    }

    //本题的解决方法入口
    //理论上就是找topK的元素，这里K是middle，即长度的一半
    public static int moreThanHalf(int[] array)
    {
        if (array == null)
        {
            return 0;
        }
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != middle)
        {
            if (index < middle)
            {
                index = partition(array, index + 1, end);
            }
            else
            {
                index = partition(array, start, index - 1);
            }
        }
        if (isMoreThanHalf(array, array[middle]))
        {
            return array[middle];
        }
        else
            return 0;
    }

    //检验某个数字是否是出现次数超过一半的数字
    public static boolean isMoreThanHalf(int[] array, int number)
    {
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                cnt++;
        }
        if (cnt >= array.length >> 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void swap(int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 方法2：
     * 类似缓存方法，利用数组特性
     * 遍历，当下一个数和保存的数一样，cnt++，不一样 cnt--
     * 由于若存在满足题意的数，cnt一定大于其他所有数字出现的次数之和
     * @param array
     * @return
     */
    public static int method2(int[] array)
    {
        if (array == null) return 0;
        int result = array[0];
        int cnt = 0;
        for (int i = 1; i < array.length; i++) {
            if (cnt == 0)
            {
                result = array[i];
                cnt = 1;
            }
            else if (array[i] == result)
            {
                cnt++;
            }
            else {
                cnt--;
            }
        }
        if (isMoreThanHalf(array, result))
        {
            return result;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(method2(new int[]{4, 2, 3, 2, 2, 2, 3, 0, 2}));
        System.out.println(method2(new int[]{1, 1, 3, 1}));
        System.out.println(moreThanHalf(new int[]{4, 2, 3, 2, 2, 2, 3, 0, 2}));
        System.out.println(moreThanHalf(new int[]{1, 1, 3, 1}));
    }
}
