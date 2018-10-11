package tree;

/**
 * 题目：二叉树的镜像
 *
 * 描述：
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 * 思路：递归交换左右子树即可
 */
public class Main27 {

    public void Mirror(TreeNode root) {
        TreeNode t=null;
        if (root==null)
            return;
        else {
            t=root.right;
            root.right=root.left;
            root.left=t;

        }

        if (root.left!=null)
            Mirror(root.left);
        if (root.right!=null)
            Mirror(root.right);



    }



}
