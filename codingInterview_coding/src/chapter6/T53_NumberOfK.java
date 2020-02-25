package chapter6;

/**
 * 在排序数组中查找数字
 *      统计某个数字在已排序数组中出现的次数
 */
public class T53_NumberOfK {
    /**
     * 正常的查找，包括二分，对于这类特殊问题效率较低
     * 采用改进的二分查找：比如统计数字k，争取直接定位到第一个k和最后一个k，计算长度就可以直接得到数字k的个数了
     *      案例：对于{1，2，3，3，3，3，4，5}，查找数字3的次数
     *          通过两次二分法判断出3的位置下界和上界
     */
    public int getNumberOfK(int[] array, int k)
    {
        if(array == null || array.length < 1) return -1;
        int cnt = 0;
        int upper = getUpperBound(array, 0 , array.length - 1, k);
        int lower = getLowerBound(array, 0 , array.length - 1, k);
        System.out.println(upper + "," + lower);
        if (lower > -1 && upper > -1 && lower < array.length && upper < array.length)
        {
            cnt = upper - lower + 1;
        }
        return cnt;
    }

    public int getLowerBound(int[] array, int start, int end, int k)
    {
        if (start > end) return -1;
        int middle = (start + end) >> 1;
        if (array[middle] == k)
        {
            if ((middle > 0 && array[middle - 1] != k) || middle == 0)
                return middle;
            else
                return getLowerBound(array, start, middle - 1, k);
        }
        else if (array[middle] > k)
        {
            return getLowerBound(array, start, middle - 1, k);
        }
        else
        {
            return getLowerBound(array, middle + 1, end, k);
        }
    }

    public int getUpperBound(int[] array, int start, int end, int k)
    {
        if (start > end) return -1;
        int middle = (start + end) >> 1;
        if (array[middle] == k)
        {
            if ((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1)
                return middle;
            else
                return getUpperBound(array, middle + 1, end, k);
        }
        else if (array[middle] > k)
        {
            return getUpperBound(array, start, middle - 1, k);
        }
        else
        {
            return getUpperBound(array, middle + 1, end, k);
        }
    }


    /**
     * 方法2：可以从头开始遍历，从尾开始遍历，找到上下界，这个比直接遍历应该略快
     */

    public static void main(String[] args) {
        System.out.println(new T53_NumberOfK().getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
    }


    /**
     * 53-2： 0 - n-1 中缺失的数字
     * 方法1：二分法
     * 由于正常情况下，不缺情况，每个数字和其下标应一一对应
     * 那么使用二分查找，如果某个数下标与其数相等，说明其左边是正确的序列，二分在右边查找
     *                 如果不相等，说明其左边不是正确的序列，如果前一个相等，则说明这个数的下标就是缺失的那个，如果前一个不相等，则再二分在前边找
     * 方法2：异或
     */


    /**
     * 53-3：数组中数值和其下标相等的元素
     * 二分法
     */
}
