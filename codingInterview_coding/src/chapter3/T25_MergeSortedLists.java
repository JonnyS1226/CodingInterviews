package chapter3;

/**
 * 合并两个排序的链表
 */
public class T25_MergeSortedLists {
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
     * 使用归并排序的思想
     * 非递归
     * @param l1
     * @param l2
     * @return 排序后的链表首结点
     */
    public static ListNode mergeSortedListIter(ListNode l1, ListNode l2)
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode mergeHead = null;
        //确定头结点
        if (l1.val <= l2.val)
        {
            mergeHead = l1;
            l1 = l1.next;
        }
        else {
            mergeHead = l2;
            l2 = l2.next;
        }
        ListNode mergeCurr = mergeHead;

        while(l1 != null || l2 != null)
        {
            if (l1 == null)
            {
                mergeCurr.next = l2;
                break;
            }
            if (l2 == null)
            {
                mergeCurr.next = l1;
                break;
            }
            if (l1.val <= l2.val)
            {
                mergeCurr.next = l1;
                mergeCurr = mergeCurr.next;
                l1 = l1.next;
            }
            if (l1.val > l2.val)
            {
                mergeCurr.next = l2;
                mergeCurr = mergeCurr.next;
                l2 = l2.next;
            }
        }
        return mergeHead;
    }

    public static ListNode mergeSortedLisrRecur(ListNode l1, ListNode l2)
    {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode mergeHead = null;
        if (l1.val < l2.val)
        {
            mergeHead = l1;
            mergeHead.next = mergeSortedLisrRecur(l1.next, l2);
        }
        else
        {
            mergeHead = l2;
            mergeHead.next = mergeSortedLisrRecur(l1, l2.next);
        }
        return mergeHead;
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
        l1.addFirst(99);
        l1.addFirst(15);
        l1.addFirst(10);
        l1.addFirst(8);
        l1.addFirst(4);
        l1.addFirst(2);
        printLinkedList(l1);

        ListNode l2 = new ListNode(0);
        l2.addFirst(76);
        l2.addFirst(56);
        l2.addFirst(13);
        l2.addFirst(6);
        l2.addFirst(5);
        printLinkedList(l2);

//        ListNode mergeHeadIter = mergeSortedListIter(l1, l2);
//        printLinkedList(mergeHeadIter);

        ListNode mergeHeadRecur = mergeSortedLisrRecur(l1, l2);
        printLinkedList(mergeHeadRecur);
    }
}
