package string;

import java.util.*;

/**
 * 题目：数据流中的中位数
 *
 * 描述：
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 */
public class Main41_1 {
    //左边利用大根堆
    private PriorityQueue<Integer> left=new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    //右边利用小根堆
    private PriorityQueue<Integer> right=new PriorityQueue<>();
    //计数器
    private int N;


    public void Insert(Integer num) {
        if (N%2==0){
            left.add(num);
            right.add(left.poll());

        }else {
            right.add(num);
            left.add(right.poll());
        }
        N++;



    }

    public Double GetMedian() {
        if (N%2==0){
            return (left.peek()+right.peek())/2.0;
        }
        else
            return Double.valueOf(right.peek());


    }

}
