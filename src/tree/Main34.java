package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树中和为某一值的路径
 *
 * 描述：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 *
 */
public class Main34 {

    private ArrayList<Integer> list=new ArrayList<Integer>();
    private ArrayList<ArrayList<Integer>> listAll=new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return listAll;
        target-=root.val;
        list.add(root.val);
        if (target==0&&root.right==null&&root.left==null){
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        //已到叶节点之后会跳过两个递归函数到这里，此时要把最后一个结点从路径中删除，才能返回上层结点
        list.remove(list.size()-1);
        return listAll;


    }

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target){
        backTracking(root,target,new ArrayList<Integer>());
        return listAll;


    }

    private void backTracking(TreeNode root,int target,ArrayList<Integer> path){
        if (root==null)
            return;
        path.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null)
            listAll.add(new ArrayList<Integer>(path));
        backTracking(root.left,target,path);
        backTracking(root.right,target,path);
        path.remove(path.size()-1);




    }
}
