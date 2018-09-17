package array;

/**
 * 题目：数组中出现次数超过一半的数字
 *
 * 描述：
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 */

public class Main39 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length==0||array==null)
        return 0;
        int majortiy=array[0];
        int count=1;
        //遍历数组找到出现次数最多的元素
        for (int i=1;i<array.length;i++){
            if (array[i]==majortiy)
                count++;
            else
                count--;
            //此时说明，数量最多的元素不存在或者不超过半数
            if (count==0){
                majortiy=array[i];
                count=1;
            }

        }
        //将计数器清零
        count=0;
        //再次遍历数组，统计出现最多元素的数量
        for (int e:array){
            if (e==majortiy){
                count++;
            }
        }
        if (count>array.length/2)
            return majortiy;
        else return 0;



    }
}
