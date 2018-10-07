package linkedList;

/**
 * 题目：删除排序链表中重复的节点
 *
 * 描述：在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：由于是已经排序好的链表，需要确定重复区域的长度，删除后还需要将被删去的前与后连接，
 * 所以需要三个节点pre,cur,post，cur-post为重复区域，删除后将pre与post.next连接即可。
   此外，要注意被删结点区域处在链表头部的情况，因为需要修改head。
 *
 *
 */
public class Main18_2 {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null)
            return pHead;
        ListNode pre=null;
        ListNode cur=pHead;
        ListNode post=pHead.next;
        boolean isNeedDelete=false;
        while (post!=null){
            if (cur.val==post.val){
                isNeedDelete=true;
                post=post.next;
            }else if (isNeedDelete){
                    if (pre==null)
                        pHead=post;
                    else
                        pre.next=post;
                    cur=post;
                    post=cur.next;
                    isNeedDelete=false;
                }
            else{
                pre=cur;
                cur=post;
                post=post.next;

            }


        }
        if (isNeedDelete&&pre!=null){
            pre.next=null;
        }else if (isNeedDelete&&pre==null){
            pHead=null;
        }

        return pHead;



    }



}
