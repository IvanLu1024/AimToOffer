package string;

/**
 * 题目：正则表达式的匹配
 *
 * 描述：
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 *
 * 分析：
 *
 * 链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
 * 来源：牛客网
 *
 * 当模式中的第二个字符不是“*”时：
 * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 *
 * 而当模式中的第二个字符是“*”时：
 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * 1、模式后移2字符，相当于x*被忽略；
 * 2、字符串后移1字符，模式后移2字符；
 * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 *
 */
public class Main19 {

    public boolean match(char[] str, char[] pattern)
    {
        if (str==null||pattern==null)
            return false;
        int strIndex=0,patternIndex=0;
        return coreMatch(str,strIndex,pattern,patternIndex);


    }

    private boolean coreMatch(char[] str,int strIndex,char[] pattern,int patternIndex){
        if (strIndex==str.length&&patternIndex==pattern.length)
            return true;
        if (patternIndex==pattern.length&&strIndex!=str.length)
            return false;

        //当模式的第二个字符为*时
        if (patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
            //模式的第2个是*并且字符串第1个和模式第一个匹配时，有3中匹配模式；
            if ((strIndex!=str.length&&pattern[patternIndex]==str[strIndex]||(pattern[patternIndex]=='.'&&strIndex!=str.length))){
                return coreMatch(str,strIndex,pattern,patternIndex+2)//模式后移两位，x*匹配0个字符
                        ||coreMatch(str,strIndex+1,pattern,patternIndex+2)//匹配一个字符
                        ||coreMatch(str,strIndex+1,pattern,patternIndex);//匹配一个，再匹配str中的下一个
            }
            //字符串第一个字符和模式第一个字符不匹配，则模式后移2个字符，继续匹配
            else {
                return coreMatch(str,strIndex,pattern,patternIndex+2);
            }

        }


        if ((strIndex!=str.length&&pattern[patternIndex]==str[strIndex])||(pattern[patternIndex]=='.'&&strIndex!=str.length)){
            return coreMatch(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;



    }

}
