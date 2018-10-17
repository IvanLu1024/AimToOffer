package tree;

import org.junit.Test;

/**
 * 题目：二叉搜索树的后序遍历
 *
 * 描述：
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *
 */
public class Main33 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0)
            return false;

        return juge(sequence,0,sequence.length-1);

    }

    private boolean juge(int[] array,int start,int end){
        if (end<=start)
            return true;
        int root=array[end];
        //寻找右子树，比根节点大的元素
        int right=start;
        for (;right<end;right++){
            if (array[right]>root)
            break;

        }

        //如果右子树中有小于根节点的元素，则不是后序
        for (int j=right;j<end;j++){
            if (array[j]<root)
                return false;
        }
        //再递归检查
        return juge(array,start,right-1)&&juge(array,right,end-1);

    }
    @Test
    public  void  test(){
        int[] nums = {1,2,3,4,5};
        boolean b = VerifySquenceOfBST(nums);
        System.out.println(b);

    }


}
