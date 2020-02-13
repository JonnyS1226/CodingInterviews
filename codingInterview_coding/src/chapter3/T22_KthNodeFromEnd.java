package chapter3;

/**
 * 输出单向链表中倒数第k个节点
 *      规定：最后一个称为倒数第一个节点
 */
public class T22_KthNodeFromEnd {
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
     * 22——1：倒数第k个节点
     * 使用两个指针来完成，首先指针first先找到从前向后的的第k个节点（也从1开始计数），然后指针second指向队首
     * 这种情况下，当first和second同时右移，当first指向队尾时，second就指向了倒数第k个
     * 但是要注意鲁棒性：
     *      k=0：单独返回null
     *      k>length：也是返回null，可以一开始判断，也可以在first找到从前往后第k个节点时增加条件
     *      链表为空情况：单独判定，返回null
     * @param head
     * @param k
     * @return
     */
    public static ListNode kthFromEnd(ListNode head, int k)
    {
        if (head == null || k == 0)
        {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i < k; i++) {
            if (first.next != null)
            {
                first = first.next;
            }
            else {
                return null;
            }
        }
        while (first.next != null)
        {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    /**
     * 22——2：求链表中间节点，若长度是偶数，返回两个中的任意一格
     * 定义两个指针同时从起点向后走，一个一次走一格，一个一次走两格，当快的走到了尾部，慢的即在中间
     * @param head
     * @return
     */
    public static ListNode middleListNode(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
        l1.addFirst(4);
        l1.addFirst(15);
        l1.addFirst(99);
        printLinkedList(l1);

        System.out.println(kthFromEnd(l1, 3).val);
        System.out.println(kthFromEnd(l1, 1).val);
        System.out.println(kthFromEnd(l1, 2).val);
        System.out.println(kthFromEnd(l1, 0));
        System.out.println(kthFromEnd(l1, 10));

        System.out.println(middleListNode(l1).val);
        l1.addFirst(0);
        printLinkedList(l1);
        System.out.println(middleListNode(l1).val);
    }
}
