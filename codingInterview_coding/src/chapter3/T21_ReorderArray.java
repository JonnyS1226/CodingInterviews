package chapter3;

/**
 * 调整数组顺序使奇数位于偶数前面
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，偶数位于后半部分
 */
public class T21_ReorderArray {
    /**
     * 由于不要求调整后奇数和偶数内部的顺序不变，所以可以使用快排的思想
     * 从前往后找第一个偶数，从后往前找第一个奇数，交换
     * 循环上述过程，直到前指针>后指针，说明已经调整完成
     * @param array
     * @return
     */
    public static int[] reorderArray(int[] array, int length){
        if (array == null || length <= 0)
        {
            return null;
        }
        int start = 0;
        int end = length - 1;
        while (start < length && end >= 0 && start < end)
        {
            while (start < end && ((array[start] & 1) != 0))
            {
                start++;
            }

            while (start < end && ((array[end] & 1)== 0))
            {
                end--;
            }
            if (start < end)
            {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
        return array;
    }

    /*
    若为了解耦，可以单独定义一个函数用来判定数组调整顺序的条件，然后在上面的循环条件中改成调用这个函数即可
    事实上，快速排序就是将小的放在大的前面，故本质也是一样的
    public static boolean isEven(int n)
    {
        return (n & 1) == 0;
    }
    */

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 3, 7, 9, 6, 5, 11, 12};
        int[] rs = reorderArray(array, array.length);
        for (int r : rs) {
            System.out.print(r + " ");
        }
        System.out.println();

        rs = reorderArray(new int[]{1, 11, 3, 7, 9, 6}, 5);
        for (int r : rs) {
            System.out.print(r + " ");
        }
        System.out.println();

        rs = reorderArray(new int[]{2, 6, 8, 10, -1}, 5);
        for (int r : rs) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
