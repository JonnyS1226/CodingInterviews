package chapter5;

/**
 * 最小的k个数
 */
public class T40_KLeastNumbers {

    /**
     * 方法1：使用快排的思想延伸，类似T39
     * @param array
     * @param k
     * @return
     */
    public static int[] KLeastNumbers(int[] array, int k)
    {
        if (array == null || k < 0 || k > array.length)
            return null;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != k - 1)
        {
            if (index > k - 1)
                index = partition(array, start, index - 1);
            else
                index = partition(array, index + 1, end);
        }
        int[] rs = new int[k];
        for (int i = 0; i < k; i++) {
            rs[i] = array[i];
        }
        return rs;
    }

    public static int partition(int[] array, int start, int end)
    {
        int pivot = array[start];
        while (start < end)
        {
            while (start < end && array[end] >= pivot)
                end--;
            array[start] = array[end];
            while (start < end && array[start] <= pivot)
                start++;
            array[end] = array[start];
        }
        array[start] = pivot;
        return end;
    }




    /**
     * 方法2：使用大顶堆来保存数组中的值，大顶堆的节点个数设定为k
     * 当新遍历一个元素时，若这个元素大于堆顶（大顶堆堆顶最大），则一定不是最小的k个
     * 若小于大顶堆最后一个元素（大顶堆中最小的），则按照大顶堆的替换顺序，替换掉原有大顶堆中的某个节点。 注：初始设定为第1层
     * 适合海量数据！
     * @param array
     * @return
     */
    public static int[] getKLeastHeap(int[] array, int k)
    {
        if (array == null || k < 0 || k > array.length)
            return null;
        //0号空闲
        int[] heap = new int[k + 1];
        int i = 0;
        while (i < k)
        {
            heap[i + 1] = array[i];
            ++i;
        }
        //初始化堆
        buildHeap(heap);
        for (int j = 0; j < array.length; j++) {
            if (array[i] < heap[k])
            {
                heap[1] = array[i];
                //adjustHeap中参数i表示要调整的节点
                adjustHeap(heap, 1);
            }
            i++;
        }
        int[] rs = new int[k];
        System.arraycopy(heap, 1, rs, 0, k);
        return rs;
    }

    //构造大顶堆
    public static void buildHeap(int[] heap)
    {
        for (int i = heap.length >> 1; i > 0; i--) {
            adjustHeap(heap, i);
        }
    }

    //调整大顶堆
    public static void adjustHeap(int[] heap, int i)
    {
        int tmp = heap[i];
        for (int j = 2 * i; j < heap.length; j = j * 2) {
            if (j < heap.length && heap[j] < heap[j + 1])
            {
                j++;
            }
            if (heap[j] > tmp)
            {
                heap[i] = heap[j];
                i = j;
            }
            else
            {
                break;
            }
        }
        heap[i] = tmp;
    }



    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] rs = KLeastNumbers(array, 5);
        for (int r : rs) {
            System.out.print(r);
        }


    }
}
