package array;

import org.junit.Test;

/**
 *  题目：数组中的逆序对
 *
 *  描述：
 *      在数组中的两个数字，
 *      如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 *      并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 *  输入描述：
 *          题目保证输入的数组中没有的相同的数字
 *
 *      数据范围：
 *
 * 	    对于%50的数据,size<=10^4
 *
 * 	    对于%75的数据,size<=10^5
 *
 * 	    对于%100的数据,size<=2*10^5
 *
 *  输入：
 *      1,2,3,4,5,6,7,0
 *
 *  输出：
 *      7
 *
 *  思路：带有计数功能的归并排序
 *
 *
 *
 */
public class Main51 {

    private long count=0;
    private int[] tmp;

    public int InversePairs(int [] array) {
        tmp=new int[array.length];
        mergeSort(array,0,array.length-1);
        return (int) (count%1000000007);


        }
        private void mergeSort(int[] nums,int l,int h){
            if (h-1<l)
                return;
            int m=l+(h-l)/2;
            mergeSort(nums,l,m);
            mergeSort(nums,m+1,h);
            merge(nums,l,m,h);


        }

        private void merge(int[] nums,int l,int m,int h){
            int i=l,j=m+1,k=l;
            while (i<=m||j<=h){
                //证明前一部分数组已经为空，直接依次取出后一部分数组即可
                if (i>m)
                    tmp[k]=nums[j++];
                //同理，后一部分数组为空，依次取出前一部分数组即可
                else if (j>h)
                    tmp[k]=nums[i++];
                //将两个数组中较小的数放入辅助数组中
                else if (nums[i]<nums[j])
                    tmp[k]=nums[i++];
                //当num[i]>num[j],表明从i到m的元素，均大于num[j]
                else {
                    tmp[k]=nums[j++];
                    this.count+=m-i+1;
                }
                k++;

            }
            for (k=l;k<=h;k++){
                nums[k]=tmp[k];
            }



        }



    @Test
    public void test(){
        int i = InversePairs(new int[]{1, 2, 3, 4, 5, 6,  0});
        System.out.println(i);

    }
}
