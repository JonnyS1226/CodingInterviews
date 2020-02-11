package chapter2;

import java.util.Stack;

/**
 * 06_链表反置输出
 */
public class T06_PrintListInReverseOrder {
    //不带哨兵的链表结构
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
        ListNode(int x, ListNode l1){
            this.val = x;
            this.next = l1;
        }
        public void addFirst(int x){
            this.next = new ListNode(x, this.next);
        }
    }

    //迭代反序输出
    public static void printListReverseIteratively(ListNode pHead){
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = pHead;
        while (tmp != null)
        {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (!stack.empty())
        {
            tmp = stack.pop();
            if (!stack.empty())
                System.out.print(tmp.val + "--->");
            else
                System.out.println(tmp.val);
        }
    }

    public static void printListReverseRecursively(ListNode pHead){
        ListNode tmp = pHead;
        if (tmp != null)
        {
            if (tmp.next != null)
            {
                printListReverseRecursively(tmp.next);
            }
            //递归出口
            if (tmp.next == null)
                System.out.print(tmp.val);
            else
                System.out.print("--->" + tmp.val);

        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(8);
        l1.addFirst(10);
        System.out.println("原链表为:");
        ListNode save = l1;
        while (l1 != null)
        {
            if (l1.next != null)
                System.out.print(l1.val + "--->");
            else
                System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();
        l1 = save;
        System.out.println("两种方法逆序输出结果为:");
        printListReverseIteratively(l1);
        printListReverseRecursively(l1);
    }
}
