package string;

import org.junit.Test;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * Created by Ivan Lu on 2018/9/25.
 */
public class Main5 {

    public String replaceSpace(StringBuffer str) {
        if (str==null||str.length()==0)
            return null;
        String reslut = str.toString().replaceAll(" ", "%20");
        return reslut;

    }

    public String repalaceSpace2(StringBuffer str){
        int n = str.length() - 1;
        for (int i=0;i<=n;i++){
            if (str.charAt(i)==' ')
                str.append("  ");

        }
        int p = str.length() - 1;
        while (n>=0&&p>n){
            char c = str.charAt(n--);
            if (c==' '){
                str.setCharAt(p--,'0');
                str.setCharAt(p--,'2');
                str.setCharAt(p--,'%');
            }else {
                str.setCharAt(p--,c);
            }

        }
        return str.toString();


    }

    @Test
    public void test(){
        StringBuffer str=new StringBuffer("We Are Happy");

        String replace = repalaceSpace2(str);
        System.out.println(replace);

    }

}
