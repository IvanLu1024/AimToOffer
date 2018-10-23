package tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 题目：搜索二叉树的第K个结点
 *
 * 描述：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 *
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 *
 * Created by Ivan Lu on 2018/10/23.
 */
public class Main54 {
    private int COUNT=0;
    private TreeNode res=null;

    //非递归的方式，中序遍历
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k <= 0) {
            return null;
        }
        TreeNode cur=pRoot;
        Stack<TreeNode> stack=new Stack<>();
        int count=0;
        while (!stack.isEmpty()||cur!=null){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                count++;
                if (count==k)
                    return cur;
                cur=cur.right;
            }
        }
        return null;
    }

    //递归的方式，中序遍历
    TreeNode KthNode1(TreeNode pRoot, int k)
    {
        inOrder(pRoot,k);
        return res;

    }
    private void inOrder(TreeNode root,int k){
        if (root==null||COUNT>=k)
            return;
        inOrder(root.left,k);
        COUNT++;
        if (k==COUNT)
            res=root;
        inOrder(root.right,k);

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

        TreeNode treeNode = KthNode1(t1, 4);
        System.out.println(treeNode.val);


    }
}
