package recursion;

import java.util.function.IntPredicate;
import java.util.zip.DeflaterInputStream;

/**
 * @author rjjerry
 */
public class HanoiTower {
    public static int num = 0;
    public static void main(String[] args) {
        String a ="A";
        String b ="B";
        String c ="C";
        hanoi(4,a,c,b);

        hanoi2(4,a,c,b);
        System.out.println("共移动了 " + num + "次");
    }

    /**
     * 将n个盘子从x借助y移到z上
     * @param n 移动的盘子树。
     * @param x 开始位置
     * @param y 中间位置
     * @param z 目标位置
     */
    public static void hanoi (int n, String x, String y, String z){
        if (n < 0){
            System.out.println("汉诺塔层数小于1");
        }else if(n == 1){
            System.out.println("移动 1 号盘子 "+ x +" ---> "+z);
            return;
        }else{
            hanoi(n - 1, x, z, y);
            System.out.println("移动 " + n + " 号盘子 "+x+" ---> "+z);
            hanoi(n - 1, y, x, z);
        }
    }

    public static void hanoi2(int n, String x, String y, String z){

        if (n == 0){

        }else {
            hanoi2(n-1,x,z,y);
            num++;
            System.out.println("第"+ num + "步，将 " + n +" 号盘从 " + x +" 移至 " + z);
            hanoi2(n-1,y,x,z);
        }
    }
}
