package chapter3;

import chapter2.T06_PrintListInReverseOrder;

/**
 * 删除链表的节点
 *      给定单向链表的头指针和一个节点指针，定义一个函数在O(1)的时间内删除该链表节点
 */
public class T18_01_DeleteNodeInList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val = x;
        }
        public ListNode(int x, ListNode l1)
        {
            this.val = x;
            this.next = l1;
        }
        public void addFirst(int x)
        {
            this.next = new ListNode(x, this.next);
        }
    }

    /**
     * 通常情况下，删除节点需要从头开始遍历，但这样是O(n)
     * 而为了O(1)时间复杂度，可以将下一个节点复制到当前的节点，然后删除下一个节点即可
     */
    public static void deleteNode(ListNode head, ListNode toDelete){
        if (head == null || toDelete == null)
        {
            return;
        }
        //普通情况
        if (toDelete.next != null)
        {
            ListNode nxt = toDelete.next;
            toDelete.val = nxt.val;
            toDelete.next = nxt.next;
            nxt = null;
        }
        //要删除头节点，且该链表只有一个头结点
        else if (head == toDelete)
        {
            head = null;
            toDelete = null;
        }
        //要删除节点是尾节点
        else {
            ListNode p = head;
            while (p.next != toDelete)
            {
                p = p.next;
            }
            p.next = null;
            toDelete = null;
        }
    }

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
        printLinkedList(l1);
        ListNode toDelete = l1;
        toDelete = toDelete.next.next.next;
        deleteNode(l1, toDelete);
        printLinkedList(l1);
    }
}
