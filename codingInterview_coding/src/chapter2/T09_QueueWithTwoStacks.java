package chapter2;

import java.util.Stack;

/**
 * 用两个栈模拟一个队列
 *      实现队列的两个函数appendTail和deleteHead实现在队列尾部插入节点和在队列首部删除节点的功能
 */
public class T09_QueueWithTwoStacks {
    // 两个栈实现的队列类
    public static class CQueue<T>{
        // 用于插入
        private Stack<T> stack1 = new Stack<>();
        // 用于弹出和删除
        private Stack<T> stack2 = new Stack<>();

        public CQueue(){}
        //队尾插入
        public void appendTail(T t)
        {
            stack1.add(t);
        }

        //队首删除
        //若stack2为空，说明之前都是插入操作。于是将stack1的元素依次pop到stack2中，stack2栈顶即是要删除的队首
        // 若stack2不为空，则先将stack2的出栈即可
        // 此时这个队列的顺序从头到尾是：stack2从上到下 ---> stack1 从下到上
        public void deleteHead()
        {
            if (stack2.isEmpty())
            {
                while (!stack1.isEmpty())
                {
                    stack2.add(stack1.pop());
                }
            }
            if (stack2.isEmpty())
            {
                throw new RuntimeException("it's an empty queue");
            }
            stack2.pop();
        }

        //输出
        public void printQueue(){
            Stack<T> tmpStack1 = (Stack<T>) stack1.clone();
            Stack<T> tmpStack2 = (Stack<T>) stack2.clone();
            System.out.print("队列为：");
            while (!tmpStack2.isEmpty())
            {
                System.out.print(tmpStack2.pop() + "  ");
            }
            while (!tmpStack1.isEmpty())
            {
                tmpStack2.add(tmpStack1.pop());
            }
            while (!tmpStack2.isEmpty())
            {
                System.out.print(tmpStack2.pop() + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CQueue<Integer> cQueue = new CQueue<>();
        cQueue.appendTail(1);
        cQueue.appendTail(3);
        cQueue.appendTail(5);
        cQueue.appendTail(6);
        cQueue.appendTail(7);
        cQueue.appendTail(9);
        cQueue.appendTail(50);
//        cQueue.printQueue();
        cQueue.deleteHead();
        cQueue.printQueue();
        cQueue.deleteHead();
        cQueue.printQueue();
        cQueue.appendTail(100);
        cQueue.printQueue();
    }

}
