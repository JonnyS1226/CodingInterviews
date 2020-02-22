package chapter3;

/**
 * 反置链表
 *      输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 */
public class T24_ReverseList {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x)
        {
            this.val = x;
        }
        public ListNode(int x, ListNode listNode)
        {
            this.val = x;
            this.next = listNode;
        }
        public void addFirst(int x)
        {
            this.next = new ListNode(x, this.next);
        }
    }

    /**
     * 反转链表--迭代法
     * 使用三个指针，分别指向当前，当前前一个，当前后一个链表节点，将当前结点.next指向前一个，将当前后一个结点.next指向当前
     * @param head  原头结点
     * @return  新头结点
     */
    public static ListNode reverseList(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        if (head.next == null)
        {
            return head;
        }
        ListNode newHead = null;
        //下面三个分别指向当前，当前前一个，当前后一个
        ListNode curr = head;
        ListNode pre = null;
        ListNode pNext = null;
        while (curr != null)
        {
            pNext = curr.next;
            if (pNext == null)
            {
                newHead = curr;
            }
            curr.next = pre;
            pre = curr;
            curr = pNext;
        }
        return newHead;
    }

    /**
     * 递归法实现反转链表
     * 类似于压栈，链表从后往前处理
     * @param head
     * @return
     */
    public static ListNode reverseListRecursively(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        // newHead永远是反转后的头结点
        ListNode newHead = reverseListRecursively(head.next);
        //以下保证如:  p->q->l，执行后变成p->q<-l，由此往前递归即可
        ListNode pNext = head.next;
        pNext.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 打印链表
     * @param l1
     */
    public static void printLinkedList(ListNode l1)
    {
        System.out.println("链表为:");
        while (l1 != null)
        {
            if (l1.next != null)
                System.out.print(l1.val + "--->");
            else
                System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.addFirst(2);
        l1.addFirst(3);
        l1.addFirst(8);
        l1.addFirst(10);
        l1.addFirst(4);
        l1.addFirst(15);
        l1.addFirst(99);
        printLinkedList(l1);
//        ListNode newHead = reverseList(l1);
//        printLinkedList(newHead);

        ListNode newHead2 = reverseListRecursively(l1);
        printLinkedList(newHead2);
    }
}
