package chapter6;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class T59_MaxInSlidingWindow {
    /**
     * 滑动窗口的最大值
     *      给定一个数组和一个滑动窗口的大小，找出所有滑动窗口里的最大值。
     *      例如，输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口大小3，则一共存在6个滑动窗口，它们的最大值分别是{4, 4, 6, 6, 6, 5}
     */
    /**
     * 解决：使用双向队列保存最大值的下标，则队列头一定是最大值的下标
     *      1. 当窗口移动时，先判断队首最大值是否在窗口内，不在则直接删除，在则继续
     *      2. 窗口移动时，尾部需要加进来一个元素，先判断队列尾部对应元素是否小于新的元素，若小于则一个个地删除
     *      3. 此时队列中存放的就是这一个窗口中，最大值的下标了
     */
    public static int[] maxInSlide(int[] array, int k)
    {
        if (array == null || k < 1) return null;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[array.length - k + 1];
        for (int i = 0; i < array.length; i++) {
            //上面所述条件第一条
            if (!deque.isEmpty() && deque.peekFirst() < (i - k + 1))
            {
                deque.removeFirst();
            }
            // 第二条
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i])
            {
                deque.removeLast();
            }
            if (i >= k - 1)
            {
                ans[i - k + 1] = array[deque.peekFirst()];
            }
        }
        return ans;
    }






    /**
     * 队列的最大值
     *      定义一个队列，实现函数max得到队列里的最大值，要求函数max，push，pop都是时间复杂度O(1)
     */
    /**
     * 解决：借用第一题的思想，一个队列存放元素，包括入队出队操作；另一个双向队列存放单调递减的元素，队首就是最大值
     */
    public class MaxQueue{
        private Queue<Integer> queue;
        private Deque<Integer> helpDeque;
        public MaxQueue()
        {
            queue = new ArrayDeque<>();
            helpDeque = new ArrayDeque<>();
        }

        public int maxValue()
        {
            if (helpDeque.isEmpty()) return -1;
            return helpDeque.peekFirst();
        }

        public void push(int val)
        {
            queue.add(val);
            while (!helpDeque.isEmpty() && helpDeque.peekLast() < val)
            {
                helpDeque.removeLast();
            }
            helpDeque.offerLast(val);
        }

        public int pop()
        {
            if (queue.isEmpty()) return -1;
            //如果出队的是最大值，双向队列中也要出去
            int ans = queue.poll();
            if (ans == helpDeque.peekFirst())
            {
                helpDeque.pollFirst();
            }
            return ans;
        }

    }



}
