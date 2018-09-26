package string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：字符流中第一个不重复的字符
 *
 * 描述：
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 *
 */
public class Main41 {

    private int[] counts=new int[256];//存放已经出现的字符
    private Queue<Character> queue=new LinkedList<>();//队列中存放当前出现次数为一次的元素

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        counts[ch]++;
        queue.add(ch);
        //当队列不为空，并且队头元素大于1时，将该元素出队
        while (!queue.isEmpty()&&(counts[queue.peek()]>1)){
            queue.poll();
        }


    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return queue.isEmpty() ? ' ' : queue.peek();

    }
}
