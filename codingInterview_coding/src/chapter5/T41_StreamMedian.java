package chapter5;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *      得到一个数据流的中位数，奇数个数就是正中间那个，偶数个数就是中间两个的平均值
 */
public class T41_StreamMedian {
    /**
     * 思想：
     *      打算最终建立两个堆，分别为大顶堆：放置较小的一部分，小顶堆：放置较大的一部分。
     *      然后保证小顶堆和大顶堆的元素个数差小于等于1
     *      这样求中位数时，若奇数个，中位数就是大顶堆顶部元素，若偶数个，中位数就是大顶堆和小顶堆顶部元素的和的一半
     * 解法：
     *      进来一个数，就存入大顶堆，然后把大顶堆顶端元素送入小顶堆
     *      若元素个数是奇数，就再把小顶堆顶部元素送到大顶堆。
     * 实现：
     *      使用优先级队列来模拟堆
     *      默认构造优先级队列会按照从小到大顺序，队首是最小元素，这样的可以模拟小顶堆
     *      然后再构造一个自定义比较函数的优先级队列，按照从大到小顺序，来模拟大顶堆
     */

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;

    public void addNum(int num)
    {
        size++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if ((size & 1) == 1)
        {
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMedian(){
        if ((size & 1) == 1 && !maxHeap.isEmpty() && !minHeap.isEmpty())
        {
            return (double) ((maxHeap.peek() + minHeap.peek()) >> 1);
        }
        else if ((size & 1) != 1 && !maxHeap.isEmpty())
        {
            return (double) maxHeap.peek();
        }
        else
        {
            return -1;
        }
    }

}
