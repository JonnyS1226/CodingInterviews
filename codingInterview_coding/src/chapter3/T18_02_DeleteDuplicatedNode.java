package chapter3;

/**
 * 删除链表中的重复节点
 *      在一个排序的链表中，删除重复的节点
 */
public class T18_02_DeleteDuplicatedNode {
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

    public static ListNode deleteDuplicatedNode(ListNode head){
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null && curr.next != null)
        {
            if (curr.val == curr.next.val)
            {
                int val = curr.val;
                while (curr !=null && curr.val == val)
                {
                    curr = curr.next;
                }
                //下面这种即一开始的若干个重复，要删除
                if (pre == null)
                {
                    head = curr;
                }
                else {
                    pre.next = curr;
                }
            }
            else
            {
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    //输出链表
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
        l1.addFirst(6);
        l1.addFirst(4);
        l1.addFirst(1);
        printLinkedList(l1);
        printLinkedList(deleteDuplicatedNode(l1));
    }
}
