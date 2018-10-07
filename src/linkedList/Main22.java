package linkedList;

import org.junit.Test;

/**
 * 题目：链表中倒数第 K 个结点
 *
 * 思路：用两个指针，当第一个指针遍历到第K个结点的时候，第二个指针开始遍历。
 * 这时当第一个指针遍历结束的时候，第二个指针此时指向的元素便是倒数第K个结点。
 *
 *
 */
public class Main22 {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0)
            return null;

        ListNode first=head;
        ListNode second=head;
        int count=1;
        for (int i=1;i<k;i++){
            if (first.next!=null)
            first=first.next;
            else
                return null;

        }
        while (first.next!=null){
            second=second.next;
            first=first.next;
        }
        return second;

    }


}
