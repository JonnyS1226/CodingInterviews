package chapter4;

import java.util.Stack;

/**
 * 包含min函数的栈
 *      定义栈的数据结构，在该类型中实现一个能够得到栈的最小元素的min函数，使得调用pop，push，min的时间复杂度都是O(1)
 */
public class T30_MinInStack {

    /**
     * 最小栈的结构
     */
    public static class StackWithMin{
        private Stack<Integer> stackData = new Stack<>();
        //存放最小值的栈
        private Stack<Integer> stackMin = new Stack<>();
        public void push(Integer data)
        {
            stackData.push(data);
            if (stackMin.isEmpty() || data < stackMin.peek())
            {
                stackMin.push(data);
            }
            else {
                stackMin.push(stackMin.peek());
            }
        }

        public int pop(){
            if (stackData.isEmpty())
            {
                throw new RuntimeException("no item");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int min(){
            if (stackMin.isEmpty())
            {
                throw new RuntimeException("No Min");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(1);
        stackWithMin.push(99);
        stackWithMin.push(9);
        int pop1 = stackWithMin.pop();
        System.out.println("pop1:" + pop1);
        stackWithMin.push(7);
        System.out.println("min:" + stackWithMin.min());
    }
}
