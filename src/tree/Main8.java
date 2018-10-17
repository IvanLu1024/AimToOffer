package tree;

import org.junit.Test;

/**
 * 题目：二叉树的下一个结点
 *
 * 描述：
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 */
public class Main8 {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode==null)
                return null;
            //如果有右子树，则下一个结点是右子树的最左端
            if (pNode.right!=null){
                pNode=pNode.right;
                while (pNode.left!=null){
                    pNode=pNode.left;
                }
                return pNode;
            }
            //如果没有右子树，向上找第一个左链接指向的树包含该节点的祖先节点
            else if (pNode.right==null){
                while (pNode.next!=null) {
                    TreeLinkNode parent = pNode.next;
                    if (parent.left==pNode){
                        return parent;
                    }
                    pNode=pNode.next;


                }
            }

            return null;

        }
        @Test
        public void test(){
            TreeLinkNode root = new TreeLinkNode(1);
            root.left = new TreeLinkNode(2);
            root.left.next = root;
            root.right = new TreeLinkNode(3);
            root.right.next = root;
            root.left.left = new TreeLinkNode(4);
            root.left.left.next = root.left;
            root.left.right = new TreeLinkNode(5);
            root.left.right.next = root.left;

            System.out.println(GetNext(root.right).val);



        }




}
