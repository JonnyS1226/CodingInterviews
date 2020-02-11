package chapter2;

import org.junit.Test;

/**
 * 11_旋转数组的最小值
 *      把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转。
 *      输入一个递增数组的一个旋转，找出最小值。 注意使用旋转数组的特性
 */
public class T11_MinNumberInRotatedArray {
    // 直接遍历数组求出最小值O(n)可行，但在这个题意下显然要用其他方法
    // 想到比O(n)更小的就是O（logn）
    // 使用二分法可以实现，middle若大于a[start]，则min在后半段，若小于，min在前半段。不断循环，最后end对应的就是最小值
    // 但是注意有可能这个旋转数组特殊，1. 就是一个普通的递增数组，2. 如test2中的多重复元素的数组
    // 下面是迭代实现的二分法
    public static int findMinInRotatedArray(int[] array)
    {
        if (array == null || array.length <= 0)
        {
            throw new IllegalArgumentException("not valid");
        }
        int start = 0;
        int end = array.length - 1;
        // 下面初始化是为了：纯递增数列不进入循环，最终返回array[indexMin]就可以输出最小值
        int indexMin = start;
        // 以下循环条件是为了让纯递增数列情况不进入循环，否则也可以用start<end
        while (array[start] >= array[end])
        {
            if (end == start + 1)
            {
                indexMin = end;
                break;
            }
            int mid = (start + end) / 2;
            // 应对test2的情况，这种情况只能遍历找最小
            if (array[start] == array[mid] && array[mid] == array[end])
            {
                return findInSortedArray(array);
            }
            if (array[mid] >= array[start])
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
        }
        return array[indexMin];
    }

    public static int findInSortedArray(int[] array)
    {
        int rs = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < rs)
            {
                rs = array[i];
            }
        }
        return rs;
    }

    @Test
    public void test1(){
        int[] array = {1, 3, 5, 8, 0};
        System.out.println("最小元素：" + findMinInRotatedArray(array));
    }

    @Test
    public void test2()
    {
        int[] array = {1, 0, 1, 1, 1};
        System.out.println("最小元素： " + findMinInRotatedArray(array));
    }

    @Test
    public void test3() {
        int[] array = {3, 4, 5, 6, 7, -1, 1, 2};
        System.out.println("最小的元素是： " + findMinInRotatedArray(array));
    }

    @Test
    public void test4(){
        int[] array = null;
        System.out.println(findMinInRotatedArray(array));
    }
}
