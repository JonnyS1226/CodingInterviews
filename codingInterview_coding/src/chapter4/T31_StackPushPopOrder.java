package chapter4;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列
 */
public class T31_StackPushPopOrder {

    /**
     * 思路：构造一个辅助栈
     * 根据出栈序列，若下一个弹出的数字不在辅助栈栈顶，则按照入栈序列继续压栈，直到出现这个数字，要是压完仍没有，则这个出栈序列就不符合
     * 如果在栈顶，则直接弹出，然后遍历下一个
     * @param pushList
     * @param popList
     * @return
     */
    public static boolean isOrder(int[] pushList, int[] popList)
    {
        if (pushList == null && popList == null)
            return true;
        if (pushList.length != popList.length || (popList == null || pushList == null))
            return false;
        Stack<Integer> stack = new Stack<>();
        int nextPushIndex = 0;
        for (int i = 0; i < popList.length; i++) {
            if (!stack.isEmpty() && popList[i] == stack.peek())
            {
                stack.pop();
            }
            else {
                if (stack.isEmpty())
                {
                    stack.push(pushList[nextPushIndex]);
                    nextPushIndex++;
                }
                while (popList[i] != stack.peek())
                {
                    if (nextPushIndex == pushList.length)
                        return false;
                    stack.push(pushList[nextPushIndex]);
                    nextPushIndex++;
                }
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushList = {1, 2, 3, 4, 5};
        int[] popList = {4, 5, 3, 2, 1};
        int[] popList2 = {4, 3, 5, 1, 2};
        int[] popList3 = {5, 4, 3, 2, 1};
        System.out.println(isOrder(pushList, popList));
        System.out.println(isOrder(pushList, popList2));
        System.out.println(isOrder(pushList, popList3));
    }
}
