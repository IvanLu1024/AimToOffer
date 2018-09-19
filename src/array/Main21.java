package array;

/**
 * 题目：
 *      21. 调整数组顺序使奇数位于偶数前面
 *
 * 描述：
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */
public class Main21 {

    public void reOrderArray(int [] array) {
        int oddCount=0;     //奇数的数量
        int[] copyArray=array.clone();  //复制一个辅助数组
        for (int i=0;i<array.length;i++)    //统计该数组中奇数的个数
            if (array[i]%2!=0)
                oddCount++;
        int i=0,j=oddCount;
        //将原数组分成两段，前一段放入奇数，后一段放入偶数
        for (int n:copyArray){
            if (n%2!=0)
            {
                array[i]=n;
                i++;
            }
            else {
                array[j]=n;
                j++;
            }

        }


    }


}
