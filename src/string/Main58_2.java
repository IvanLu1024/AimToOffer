package string;

import org.junit.Test;

/**
 * 题目：左旋转字符串
 *
 * 描述：
 * 题目描述
    Input:
    S="abcXYZdef"
    K=3

    Output:
    "XYZdefabc"
 *
 * 思路：先分别旋转，再整体旋转
 */
public class Main58_2 {

    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()==0)
            return "";
        if (n>str.length()-1)
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);

    }

    private void reverse(char[] chars,int i,int j){
        while (i<j){
            swap(chars,i++,j--);
        }

    }
    private void swap(char[] chars,int i,int j){
        char t = chars[i];
        chars[i]=chars[j];
        chars[j]=t;

    }
    @Test
    public void test(){
        String s = LeftRotateString("abcXYZdef",3);
        System.out.println(s);

    }

}
