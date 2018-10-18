package tree;

import org.junit.Test;

/**
 * 题目：对称的二叉树
 *
 * 描述：请实现一个函数，用来判断一颗二叉树是不是对称的。
 *
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 */
public class Main28 {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);



    }
    private boolean isSymmetrical(TreeNode left,TreeNode right){
        if (left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;
        if (left.val!=right.val)
            return false;
        //如果值相等的时候，继续判断其下面部分是否对称
        else
            return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
    }


    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        boolean b = isSymmetrical(t1);
        System.out.println(b);


    }

}
