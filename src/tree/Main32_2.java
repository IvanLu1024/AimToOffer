package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 按之字形来打印二叉树
 *
 * 描述：
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by Ivan Lu on 2018/10/23.
 */
public class Main32_2 {
    private ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    private Queue<TreeNode> queue=new LinkedList<>();
    private boolean flag=false;//记录是否翻转

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int size = queue.size();
            while (size-->0){
                TreeNode cur = queue.poll();
                if (cur==null)
                    continue;
                list.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            if (flag){
                Collections.reverse(list);
            }
            flag=!flag;
            if (list.size()>0){
                res.add(list);
            }


        }
        return res;

    }

    @Test
    public void test(){
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(3);
        TreeNode t3=new TreeNode(4);
        TreeNode t4=new TreeNode(7);
        TreeNode t5 = new TreeNode(2);
        t1.right=t4;
        t1.left=t2;
        t2.right=t3;
        t2.left=t5;

        ArrayList<ArrayList<Integer>> print = Print(t1);
        System.out.println(print);


    }

}
