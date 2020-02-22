package chapter5;

/**
 * 两个链表的第一个公共节点
 */
public class T52_CommonNodesInLists {
    public static class ListNode{
        ListNode next;
        int val;
    }

    /**
     * 方法1
     * 使用栈 从尾部往前比较
     * 比较到两个链表最后一个相同的节点，就是题目所需要求的节点
     */

    /**
     * 方法2
     * Hash表存储
     */

    /**
     * 方法3：定义两个指针从各自头节点 以相同速度开始走
     * 当一个节点到达尾部时，计算它们的差值x。（其实就是计算两个链表的长度差）
     * 然后第二次遍历时，第一次落后的那个节点先走x步，这样当两者相等时，则就是第一个公共节点
     */
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2)
    {
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int diffLength = (length1 > length2) ? (length1 - length2) : (length2 - length1);
        ListNode currFast = (length1 > length2) ? head1 : head2;
        ListNode currSlow = (length1 > length2) ? head2 : head1;
        for (int i = 0; i < diffLength; i++) {
            currSlow = currSlow.next;
        }
        while (currFast != null && currSlow != null && currFast != currSlow)
        {
            currFast = currFast.next;
            currSlow = currSlow.next;
        }
        ListNode commonNode = currFast;
        return commonNode;
    }

    public static int getListLength(ListNode head)
    {
        int listLength = 0;
        ListNode curr = head;
        while (curr != null)
        {
            listLength++;
            curr = curr.next;
        }
        return listLength;
    }


    /**
     * 方法4：数学规律
     * 浪漫地相遇
     * 同方法3，两个指针同速前进，当某个指针到达了尾部，它就移动到另一个链表头，这样就相当于形成了一个环
     * 于是两个指针一定会相遇，它们的相遇点就是第一个公共节点
     */


}
