package linkedList;

/**
 * 题目：反转链表
 *
 * 描述：输入一个链表，反转链表后，输出新链表的表头。
 *
 */
public class Main24 {

    public ListNode ReverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode pre=null;
        ListNode cur=head;
        ListNode post=head.next;
        while (true){
            cur.next=pre;
            pre=cur;
            cur=post;
            if (post!=null){
                post=post.next;
            }else
                return pre;

        }

    }
}
