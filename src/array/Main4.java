package array;

/**
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */
public class Main4 {


    public boolean Find(int target, int [][] array) {
        int row = array.length;//二位数组的行
        int column = array[0].length;//列
        //从数组的最左下角开始搜索，如果大则向右右移一位，反之则向向上移一位
        if (row==0||column==0||array==null)
            return false;
        int i=row-1;
        int j=0;
        while (i>=0&&j<=column-1){
            if (target==array[i][j])
                return true;
            else if (target>array[i][j])
                j++;
            else i--;
        }
        return false;


    }

    public static void main(String[] args) {
        int[][] a=new int[3][4];
        int length = a.length;
        int wid = a[0].length;
        System.out.println(length);
        System.out.println(wid);

    }

}
