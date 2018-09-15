package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：把数组排成最小的数
 *
 * 描述：
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *      例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 *
 */

public class Main45 {

    /**
     * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
     * 应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，
     * 否则应该把 S2 排在前面。
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {

        String[] str=new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<numbers.length;i++){
            str[i]=String.valueOf(numbers[i]);

        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String s12 = s1 + s2;
                String s21 = s2 + s1;
                return s12.compareTo(s21);
            }
        });

        for (String s:str){
            System.out.println(s);
            sb.append(s);

        }
        return sb.toString();



    }

    /**
     * 增加一种更加便于理解的方法
     * @param numbers
     * @return
     */
    public String PrintMinNumber2(int[] numbers){
        int n = numbers.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                String s12 = String.valueOf(numbers[i]) + String.valueOf(numbers[j]);
                String s21 = String.valueOf(numbers[j]) + String.valueOf(numbers[i]);
                if (Integer.parseInt(s12)>Integer.parseInt(s21)){
                    int t=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=t;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i:numbers){
            sb.append(i);
        }
        return sb.toString();

    }

   


}
