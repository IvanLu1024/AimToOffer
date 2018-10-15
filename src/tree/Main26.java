package tree;

import org.junit.Test;

/**
 * 题目：树的子结构
 *
 * 描述：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：
 *
 * 当A有一个节点与B的根节点值相同时，则需要从A的那个节点开始严格匹配，若严格匹配则说明B是A的子结构。
 * 
 * 如果匹配不成功，则返回到开始匹配的那个节点，对它的左右子树继续判断是否与B的根节点值相同，重复上述过程。
 *
 */
public class Main26 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2==null||root1==null)
            return false;

        if (root1.val==root2.val){
            if (DoesTree1HasTree2(root1,root2))
                return true;
        }

        return HasSubtree(root1.right,root2)||HasSubtree(root1.left,root2);

    }

    private boolean DoesTree1HasTree2(TreeNode t1,TreeNode t2){
        if (t2==null)
            return true;
        if (t1==null)
            return false;

        if (t1.val==t2.val&&DoesTree1HasTree2(t1.left,t2.left)&&DoesTree1HasTree2(t1.right,t2.right))
            return true;
        else
            return false;
    }

    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        //t2.left=t4;
        boolean b = HasSubtree(t1, t4);
        System.out.println(b);


    }
}
