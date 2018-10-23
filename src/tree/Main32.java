package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：从上到下打印二叉树
 *
 * 描述：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * Created by Ivan Lu on 2018/10/23.
 */
public class Main32 {
    private ArrayList<Integer> res=new ArrayList<>();
    private Queue<TreeNode> queue=new LinkedList<>();

    //使用队列来层次遍历该二叉树
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null)
            return res;
        queue.add(root);
        res.add(root.val);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left!=null){
                res.add(cur.left.val);
                queue.add(cur.left);
            }if (cur.right!=null){
                res.add(cur.right.val);
                queue.add(cur.right);
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

        ArrayList<Integer> list = PrintFromTopToBottom(t1);
        System.out.println(list);


    }

}
