package tree;

/**
 * 题目：重建二叉树
 *
 * 描述：
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * 思路：找出根结点，不断递归
 *
 */
public class Main7 {


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre==null||in==null)
            return null;
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);


    }
    private TreeNode reConstructBinaryTree(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd)
            return null;
        TreeNode treeNode = new TreeNode(pre[preStart]);
        for (int i=inStart;i<=inEnd;i++){
            if (pre[preStart]==in[i]){
                treeNode.left=reConstructBinaryTree(pre,preStart+1,i-inStart+preStart,in,inStart,i-1);
                treeNode.right=reConstructBinaryTree(pre,i-inStart+preStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return treeNode;

    }


}
