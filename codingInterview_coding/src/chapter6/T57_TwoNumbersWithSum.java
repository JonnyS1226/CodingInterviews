package chapter6;


public class T57_TwoNumbersWithSum {

    /**
     * 和为s的数字
     *      输入一个递增数组和一个数字s，在数组中查找两个数，使得两个数的和为s。若有多组，只需要输出一组
     */
    /**
     * 由于是排序数组，可以使用双指针
     *      一个指针start位于首部，一个指针end位于尾部，两者值相加
     *      若值小于s，则start++
     *      若值大于s，则end--
     *      直到s>=e，循环结束，就不存在
     */
    public static int[] twoNumberWithSum(int[] array, int s){
        if (array == null) return new int[]{-1};
        if (s < array[0] || s > array[array.length - 1]) return new int[]{-1};
        int start = 0;
        int end = array.length - 1;
        while (start < end)
        {
            if (array[start] + array[end] == s)
            {
                return new int[]{array[start], array[end]};
            }
            else if (array[start] + array[end] < s)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        throw new RuntimeException("no such numbers");
    }


    /**
     * 57_02: 和为s的连续正数序列
     *      首先规定这个序列至少含有两个正数。例如输入15，由于1+2+3+4+5=4+5+6+7=7+8=15，所以打印三个连续序列：1-5，4-7，7-8
     */
    /**
     *  沿用思想，small和big两个指针分别指向序列的最小和最大元素
     *      初始时，small指向1，big指向2，判断和小于：big++
     *                                  判断和大于：small++
     *      由于至少有两个元素，所以small最大加到(1+s)/2为止
     */
    public static void sequenceWithSum(int s)
    {
        if (s < 3) return;
        int small = 1;
        int big = 2;
        int curSum = small + big;
        while (small < (s + 1) >> 1)
        {
            if (curSum == s)
            {
                printSequence(small, big);
            }
            while (small < (s + 1) >> 1 && curSum > s)
            {
                curSum -= small;
                small++;
                if (curSum == s)
                {
                    printSequence(small, big);
                }
            }
            big++;
            curSum += big;
        }
    }
    public static void printSequence(int small, int big)
    {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] rs = twoNumberWithSum(new int[] { 1, 2, 4, 7, 11, 15}, 15);
        for (int r : rs) {
            System.out.print(r + " ");
        }
        System.out.println();

        sequenceWithSum(15);
    }
}
