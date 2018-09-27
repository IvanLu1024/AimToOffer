package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：字符串的排列
 *
 * 描述：
 *      输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c
 *      所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 *
 *      回溯法解决该问题
 *
 */
public class Main38 {
    private ArrayList<String> strings=new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length()==0)
            return strings;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTracking(chars,new boolean[chars.length],new StringBuilder());
        return strings;



    }

    private void backTracking(char[] chars,boolean[] hasUsed,StringBuilder s){
        if (s.length()==chars.length){
            strings.add(s.toString());
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (hasUsed[i])
                continue;
            if (i!=0&&chars[i]==chars[i-1]&&!hasUsed[i-1])//保证不重复
                continue;
            hasUsed[i]=true;
            s.append(chars[i]);
            backTracking(chars,hasUsed,s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i]=false;

        }


    }
    @Test
    public void  test(){
        ArrayList<String> list = Permutation("abc");
        for (String s:list){
            System.out.println(s);
        }


    }
}
