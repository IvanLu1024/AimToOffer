package linkedList;

/**
 * 题目：链表中环的入口(双指针总结)
 *
 * 描述：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路：使用两个指针，一个快指针，一个慢指针，块指针一次前进两步，慢指针一次前进一步
 * 两个指针从头开始遍历，若两个指针值相等的时候，则说明该链表存在环，反之则不存在环。
 *
 * 找出环的入口结点：当两个指针值相等的时候，将慢指针重新初始化为头结点，重新开始遍历链表
 * ，此时将两个指针的步长均改为1，当两个指针再次相等的时候，则此时指向的就是入口结点。
 */
public class Main23 {


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
            return null;
        ListNode slowNode=pHead;
        ListNode fastNode=pHead;
        while (fastNode!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
            if (slowNode==fastNode)
                break;
        }
        slowNode=pHead;
        while (slowNode!=fastNode){
            slowNode=slowNode.next;
            fastNode=fastNode.next;

        }
        return slowNode;

    }

}
