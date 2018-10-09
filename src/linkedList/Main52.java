package linkedList;

/**
 * 题目：两个链表的第一个公共结点
 *
 * 描述：输入两个链表，找出它们的第一个公共结点
 *
 * Created by Ivan Lu on 2018/10/9.
 */
public class Main52 {


    /**
     * 暴力法，双重循环
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        ListNode cur1=pHead1;
        ListNode cur2=pHead2;
        while (cur1!=null){
            if (cur1.val==cur2.val)
                return cur1;
            else {
                while (cur2!=null){
                    if (cur1.val==cur2.val)
                        return cur1;
                    else {
                        cur2=cur2.next;
                    }

                }
                cur2=pHead2;
                cur1=cur1.next;
            }


        }
        return null;
    }

    /**
     * 思路：由于是单链表，当出现公共结点后，其后部分均为相同。
     *  （因为2个链表用公共的尾部）
     *      当链表长度相同的时候，直接同时开始遍历，一定会找到第一个共同结点
     *      当链表长度不同的时候，让长链表先开始多出的那部分，随便两个链表同步开始，
     *      这时就转化为了链表长度相同的时候。
     * @param pHead1
     * @param pHead2
     * @return
     */

    public ListNode FindFirstCommonNode01(ListNode pHead1, ListNode pHead2) {
        int size1 = findNodeSize(pHead1);
        int size2 = findNodeSize(pHead2);
        if (size1>size2){
            pHead1 = walkStepNode(pHead1, size1 - size2);
        }else {
            pHead2= walkStepNode(pHead2, size2 - size1);
        }
        while (pHead1!=null){
            if (pHead1==pHead2)
                return pHead1;
            pHead1=pHead1.next;
            pHead2=pHead2.next;

        }
        return null;


    }
    private int findNodeSize(ListNode p){
        int count=0;
        while (p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
    private ListNode walkStepNode(ListNode p,int step){
        while (step-->0){
            p=p.next;
        }
        return p;
    }



}
