package tree;

/**
 * 题目：二叉搜索树与双向链表
 *
 * 描述：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 */
public class Main36 {
    private TreeNode pre=null;
    private TreeNode head=null;


    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;


    }

    private void inOrder(TreeNode root){
        if (root==null)
            return;
        inOrder(root.left);
        root.left=pre;
        if (pre!=null){
            pre.right=root;
        }
        pre=root;
        if (head==null)
            head=pre;
        inOrder(root.right);


    }


}
