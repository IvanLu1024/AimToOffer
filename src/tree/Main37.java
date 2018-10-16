package tree;

import org.junit.Test;

/**
 * 题目：序列化二叉树
 *
 * 描述：请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * Created by Ivan Lu on 2018/10/16.
 */
public class Main37 {

    String Serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if (root==null)
            sb.append("#,");
        else
        {
            sb.append(root.val);
            sb.append(",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();

    }
    TreeNode Deserialize(String str) {
        StringBuilder sb = new StringBuilder(str);
        return Deserialize(sb);
    }

    TreeNode Deserialize(StringBuilder sb){
        if (sb.length()==0)
            return null;
        String num = sb.substring(0, sb.indexOf(","));
        sb.delete(0,sb.indexOf(","));
        sb.deleteCharAt(0);
        if (num.equals("#"))
            return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(num));
        treeNode.left=Deserialize(sb);
        treeNode.right=Deserialize(sb);
        return treeNode;


    }
    @Test
    public void test(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        String serialize = Serialize(t1);
        System.out.println(serialize);
        TreeNode t = Deserialize("1,2,4,#,#,#,3,#,#,");

            System.out.println(t.val);
        System.out.println(t.left.val);
        System.out.println(t.right.val);



    }

}
