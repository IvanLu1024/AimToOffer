package linkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 题目：从尾到头打印链表
 *
 * 描述:
 *      输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 *
 */
public class Main6 {



    //使用栈的方式
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        if (listNode==null)
            return list;

        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        stack.push(listNode.val);
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;


    }

    //使用集合类的方法reverse
    public ArrayList<Integer> printListFromTailToHead11(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        while (listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(list);


        return list;


    }


}
