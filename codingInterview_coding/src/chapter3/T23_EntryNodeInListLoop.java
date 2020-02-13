package chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表中环的入口节点
 *      链表中有环，求入口节点
 */
public class T23_EntryNodeInListLoop {
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
     * 方法1：
     * 两个指针，一个一次走2，一个一次走1，若相遇，说明存在环
     * 通过数学推导可知，此时若再找一个指针从头开始，和相遇点的那个指针同时一次一格的走，当他们再次相遇时，就是入口点
     * 也可以通过计数cnt 来算环长度n，然后设两个从头开始的指针，一个指针先走n步，然后一起走，当两者再相遇时就是入口点
     * @param head
     * @return
     */
    public static ListNode findEntryMethod1(ListNode head){
        if (head == null)
        {
            return null;
        }
        //以下是确定是否有环，meet=null说明无环
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null && fast.next != null && slow.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                meet = fast;
                break;
            }
        }
        //下面是确定入口点
        ListNode entry = head;
        while (entry != meet)
        {
            entry = entry.next;
            meet = meet.next;
        }
        return entry;
    }


    /**
     * 方法2：
     * 用Hash存放已遍历过的点，当下一个遍历的发现在Hash表中存在，则说明成环，且那个点就是入口点
     * @param head
     * @return
     */
    public static ListNode findEntryMethod2(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode pointer = head;
        int i = 0;
        while (pointer.next != null)
        {
            if (map.containsKey(pointer))
            {
                return pointer;
            }
            map.put(pointer, i++);
            pointer = pointer.next;
        }
        return null;
    }

    /**
     * 输出链表
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
        ListNode end = l1.next;
        l1.addFirst(3);
        l1.addFirst(8);
        l1.addFirst(10);
        l1.addFirst(4);
        l1.addFirst(15);
        l1.addFirst(99);
        ListNode entry = l1.next.next;
        printLinkedList(l1);
        end.next = entry;
        //环是末尾2到15
        System.out.println(findEntryMethod1(l1).val);
        System.out.println(findEntryMethod2(l1).val);
    }
}
