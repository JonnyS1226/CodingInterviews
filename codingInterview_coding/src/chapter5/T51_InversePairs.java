package chapter5;

/**
 * 数组中的逆序对
 *      如{7，5，6，4}中，逆序对有（7，5）（7，6）（7，4）（6，4）（5，4）
 *      求出一个数组中逆序对的个数
 */
public class T51_InversePairs {
    /**
     * 使用归并排序的思想
     * 归并排序过程中增加计数，计算逆序对个数
     */
    //cnt是逆序对个数
    private int cnt = 0;

    public int inversePairs(int[] array)
    {
        if (array == null || array.length < 1) return 0;
        mergeSort(array, 0, array.length - 1);
        return cnt;
    }

    public void mergeSort(int[] array, int start, int end)
    {
        if (start == end)
            return;
        int mid = (start + end) >> 1;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        mergeSortCore(array, start, mid, end);
    }

    public void mergeSortCore(int[] array, int start, int mid, int end)
    {
        int[] resArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end)
        {
            if (array[i] <= array[j])
            {
                resArr[index++] = array[i++];
            }
            else
            {
                resArr[index++] = array[j++];
                //如果左边的第一个大于右边，则左边的后面几个一定大于右边（因为左边已经有序了）
                //所以会新构成mid-i+1个逆序对
                cnt += mid - i + 1;
            }
        }
        while (i <= mid)
        {
            resArr[index++] = array[i++];
        }
        while (j <= end)
        {
            resArr[index++] = array[j++];
        }
        System.arraycopy(resArr, 0, array, start, resArr.length);
    }

    public static void main(String[] args) {
        System.out.println(new T51_InversePairs().inversePairs(new int[] {7, 5, 6, 4}));
    }
}
