package dp;

import org.junit.Test;

/**
 * 题目：
 *      46. 把数字翻译成字符串
 *
 * 描述：
 *      给定一个数字，按照如下规则翻译成字符串：0 翻译成“a”，1 翻译成“b”... 25 翻译成“z”。
 *      一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 bccfi，bwfi，bczi，mcfi，mzi。
 *      实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 */
public class Main46 {
    private int count=0;

    public int isDecoding(String s){
        int f1=0,f2=1,g=0;
        int t;
        for (int i=s.length()-2;i>=0;i--){
            if (Integer.parseInt(s.substring(i,i+1))<26)
                g=1;
            else
                g=0;
            t=f2;
            f2=f2+g*f1;
            f1=t;
        }
        return f2;


    }
    public int getTranslationCount(int num){
        if (num<0)
            return 0;
        if (num==1)
            return 1;
        return isDecoding(num+"");


    }

    @Test
    public void test(){
        int count = isDecoding("12");
        System.out.println(count);

    }
}
