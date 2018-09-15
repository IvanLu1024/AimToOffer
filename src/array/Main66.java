package array;

import java.util.Arrays;

/**
 * 66.构建乘积数组
 *
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，
 *
 * 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 *
 * 要求不能使用除法。
 *
 */
public class Main66 {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];

        //从左往右乘,B[i]=A[0]*A[1]*...*A[i-1]
        for (int i=0,result=1;i<B.length;result*=A[i],i++){
            B[i]=result;

        }
        //从右往左乘,在第一次循环的基础上，B[i]=B[i]*A[i+1]*...*A[n-1]
        for (int i=A.length-1,result=1;i>=0;result*=A[i],i--){
            B[i]*=result;

        }

        return B;

    }

}
