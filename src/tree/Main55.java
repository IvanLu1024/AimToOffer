package tree;

import org.junit.Test;

/**
 * 题目：二叉树的深度
 *
 * 描述：输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 思路：二叉树root的深度比其子树root.left与root.right的深度的最大值大1。递归调用即可得到
 *
 */
public class Main55 {
    private int count=0;


    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        if (root.right==null&&root.left==null)
            return 1;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;

    }
    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(1);
        t1.left=t2;
        t1.right=t3;


        int i = TreeDepth(t1);
        System.out.println(i);

    }
}
