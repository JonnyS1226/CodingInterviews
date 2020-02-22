package chapter4;


/**
 * 复杂链表的复制
 *      复制一个复杂链表：链表中有next，还有sibling指向链表中任意节点或者null
 */
public class T35_CopyComplexList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode sibling;
        public ListNode(int x)
        {
            this.val = x;
        }
    }

    /**
     * 分成三步
     * 1. 复制原来的链表节点，用next连到原来节点的后面
     * 2. 将sibling的连线也复制一份，如原来A点sibling连到C点，复制后就是A' sibling连到 C'
     * 3. 将第二步得到的长链表拆分成两个一样的，就是复制完成
     * @param head
     * @return
     */
    public static ListNode copyComplexList(ListNode head)
    {
        if (head == null) return null;
        copy(head);
        setSibling(head);
        return splitList(head);
    }

    //第一步
    public static void copy(ListNode head){
        ListNode curr = head;
        while (curr != null)
        {
            ListNode ins = new ListNode(curr.val);
            ins.next = curr.next;
            curr.next = ins;
            curr = ins.next;
        }
    }

    //第二步
    public static void setSibling(ListNode head){
        ListNode curr = head;
        while (curr != null)
        {
            ListNode nxt = curr.next;
            if (curr.sibling != null)
            {
                nxt.sibling = curr.sibling.next;
            }
            curr = nxt.next;
        }
    }

    //第三步：拆分，只要分奇数位置和偶数位置拆分即可
    public static ListNode splitList(ListNode head)
    {
        ListNode curr = head;
        ListNode copyHead = head.next;
        while (curr != null)
        {
            ListNode nxt = curr.next;
            curr.next = nxt.next;
            if (nxt.next != null)
            {
                nxt.next = nxt.next.next;
            }
            curr = curr.next;
        }
        return copyHead;
    }

}
