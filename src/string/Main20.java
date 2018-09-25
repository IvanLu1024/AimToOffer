package string;

import org.junit.Test;

/**
 * 题目： 表示数值的字符串
 *
 * 描述：
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 *
 *分析：使用正则匹配的方式来解决该问题
 *
 * 补充：
 *      正则语法：
 *      []  ： 字符集合
        ()  ： 分组
        ?   ： 重复 0 ~ 1
        +   ： 重复 1 ~ n
        *   ： 重复 0 ~ n
        .   ： 任意字符
        \\. ： 转义后的 .
        \\d ： 数字
 * Created by Ivan Lu on 2018/9/25.
 */
public class Main20 {

    public boolean isNumeric(char[] str) {
        if (str==null||str.length==0)
            return false;
        String string = String.valueOf(str);
        //第一位必须为+、-或者没有，小数点只能出现一次，
        boolean flag = string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
        return flag;


    }

    @Test
    public void test(){


    }
}
