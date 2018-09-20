package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 题目：数字在排序数组中出现的次数
 *
 * 描述：统计一个数字在排序数组中出现的次数。
 *
 * 思路：1.从头开始顺序搜索，当遇到比被比较数字大的时候，跳出循环，
 *      由于是排序数组，当前数字是数组中的最小数字，若被比较数字
 *      小于当前数字，则没有必要继续搜索数组。当被比较数字等于当前数字时候，
 *      计数器加一，并将下标往后移动一位。当被比较数字小于当前数字时候，继续搜索。
 *
 *      2.二分查找：首先寻找第一个出现的k的位置，再寻找最后一个k出现的位置，两个值一相减便得到结果。
 *
 */
public class Main53 {



    public int GetNumberOfK1(int [] array , int k) {
        int i=0;
        int count=0;
        while (i<array.length){
            if (array[i]>k)
                break;
            else if (array[i]==k) {
                count++;
                i++;
            }

            else
                i++;
        }
        return count;

    }

    public int GetNumberOfK(int [] array , int k) {
        int first = BinarySerach(array, k);
        int last = BinarySerach(array, k + 1);
        if (first==array.length||array[first]>k)
            return 0;
        return (last-first);



    }

    private int BinarySerach(int[] nums,int k){
      int l=0,h=nums.length;
      while (l<h){
          int m=l+(h-l)/2;
          if (nums[m]>=k)
              h=m;
          else
              l=m+1;
      }
      return h;

    }

    @Test
    public void test(){
        int[] nums = { 1, 2, 3, 3, 3, 3, 4, 6};
        int i = GetNumberOfK(nums, 4);
        System.out.println(i);


    }
}
