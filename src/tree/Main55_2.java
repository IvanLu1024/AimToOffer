package tree;

import org.junit.Test;

/**
 * 题目：平衡二叉树
 *
 * 描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：当二叉树的左右子树的高度相差大于等于2的时候就不是平衡二叉树，
 * 高度差当小于等于1的时候是平衡二叉树
 *
 */
public class Main55_2 {

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root==null)
            return true;
        int lDeth=TreeDepth(root.left);
        int rDeth=TreeDepth(root.right);
        if (lDeth-rDeth>=2||rDeth-lDeth>=2)
            return false;
        else
            return true;

    }

    private int TreeDepth(TreeNode root){
        if (root==null)
            return 0;
        if (root.right==null&&root.left==null)
            return 1;
        return Math.max(TreeDepth(root.right),TreeDepth(root.left))+1;
    }

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(1);
        t1.left=t2;
        t2.right=t3;


        boolean i = IsBalanced_Solution(t1);
        System.out.println(i);

    }

}
