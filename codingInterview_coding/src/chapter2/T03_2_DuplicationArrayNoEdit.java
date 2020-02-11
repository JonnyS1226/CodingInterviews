package chapter2;

/**
 * 03_2_不修改数组找出数组中重复的数字
 *      在一个长度为n+1的数组里的所有数字都在1-n的范围内，所以数组中至少有一个数字是重复的，找出这个重复的
 */
public class T03_2_DuplicationArrayNoEdit {

    /**
     * 采用二分法
     *      确定一个中间元素t，然后统计1-t的元素的个数，若该个数>t，则一定有重复的，则继续二分这一段，直到end=start
     */

    // 递归
    public static int recursiveToFind(int[] array, int start, int end, int length)
    {
        if(end == start)
        {
            return start;
        }
        int middle = (end + start) / 2;
        int count = rangeCount(start, middle, array, length);
        if (count > (middle - start + 1))
        {
            return recursiveToFind(array, start, middle, length);
        }
        else {
            return recursiveToFind(array, middle + 1, end, length);
        }
    }

    // 非递归
    public static int noRecursiveToFind(int[] array, int length)
    {
        int start = 1;
        int end = length - 1;
        while (end >= start)
        {
            int middle = (end + start) / 2;
            int count = rangeCount(start, middle, array, length);
            if (end == start)
            {
                return start;
            }
            if (count > (middle - start + 1))
            {
                end = middle;
            }
            else {
                start = middle + 1;
            }
        }
        throw new IllegalArgumentException("没有重复的");
    }

    //范围统计数字个数
    public static int rangeCount(int start, int end, int[] array, int length)
    {
        if(length == 0)
        {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < length; i++)
        {
            if(array[i] <= end && array[i] >= start)
            {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 4, 2, 2, 6, 7};
//        int[] array = {1, 3, 2, 2, 4};
        int length = array.length;
        System.out.println(length);
        long a = System.currentTimeMillis();
        System.out.println("重复的元素是:" + noRecursiveToFind(array, length));
        System.out.print("非递归运行时间:");
        System.out.println(System.currentTimeMillis() - a + "ms");
        a = System.currentTimeMillis();
        System.out.println("重复的元素是:" + recursiveToFind(array, 1, length - 1, length));
        System.out.print("递归运行时间:");
        System.out.println(System.currentTimeMillis() - a + "ms");
    }
}
