package array;

import java.util.Scanner;

/**
 * 题目：数组中重复的数字
 *
 * 描述：
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 */

public class Main3 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length<=1||numbers==null)
            return false;
        for (int i=0;i<length;i++){

            //将值为i的元素不在为位置i上的元素开始交换
            while (numbers[i]!=i){
                //此时有重复
                if (numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }

        }


        return false;

    }
    private static void swap(int[] nums, int a,int b){
        int t=nums[a];
        nums[a]=nums[b];
        nums[b]=t;

    }

    public static void main(String[] args) {
        int[] arr={2, 3, 1, 0, 2, 5};
        int[] d=new int[2];
        boolean flag = duplicate(arr, arr.length, d);
        if (flag){
            System.out.println(d[0]);
        }else {
            System.out.println("null");
        }


    }


}
