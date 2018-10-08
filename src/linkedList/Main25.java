package linkedList;

/**
 * 题目：合并两个排序的链表
 *
 * 描述：输入两个单调递增的链表，
 *      输出两个链表合成后的链表，
 *      当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：类似于归并排序，每次在两个链表中选择较小的放入新的链表中，直到遍历结束；
 *      结束后将非空的链表直接加入新的链表后面即可。
 */
public class Main25 {


    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1==null&&list2==null)
            return null;
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        if (list1.val<list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }else {
            list2.next=Merge(list1,list2.next);
            return list2;
        }


    }

    public ListNode Merge01(ListNode list1,ListNode list2) {
        if (list1==null&&list2==null)
            return null;
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;

        }
        if (list1!=null)
            cur.next=list1;
        if (list2!=null)
            cur.next=list2;
        return head.next;



    }
}
