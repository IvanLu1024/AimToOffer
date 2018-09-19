package array;

import org.junit.Test;

/**
 * 题目：数组中只出现一次的数字
 *
 * 描述：一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *
 * 思路：
 * 由于该数组中只有两个单独出现的数字，其余数字均为成对出现。
 * 又因为异或运算中，相同的数计算结果为0,0与任何数字异或运算后仍是这个数字本身的特点。
 * 那么，将该数组所有数进行异或运算后，便是那两个单独出现的数字的异或结果。
 * 如果将这个数组分成两个单独出现数字的数组，那么这两个数组分别做异或运算就可以得到这两个数字的值。
 * 因为这两个不同的数字，必然有一位在二进制情况下，不同的位数，那么按照这个位数对这个数组进行分割，
 * 便可以得到两个单独出现一次数字其余均是成对出现数字的数组。
 *
 */

public class Main56 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len=array.length;
        if (len==2){
            num1[0]=array[0];
            num2[0]=array[1];
        }
        int bitReslut=0;
        for (int i=0;i<len;i++){
            bitReslut^=array[i];
        }
        int index = findFirst1(bitReslut);
        for (int i=0;i<len;i++){
            if (((array[i]>>index)&1)==0){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }

        }


    }
    private int findFirst1(int bit){
        int index=0;
       while (((bit&1)==0)&&index<32){
           bit=bit>>1;
           index++;
       }
       return index;
    }

    @Test
    public void test(){
        int first1 = findFirst1(10);
        System.out.println(first1);

    }
}

