package search;

import com.sun.tools.doclets.formats.html.HelpWriter;

/**
 * @author rjjerry
 */
public class BinSearch {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetNum = 2;
        binSearch(testArray, targetNum);
    }

    public static boolean binSearch(int[] targetArray, int targetNum) {
        boolean flag = false;
        int low = 0, high = targetArray.length - 1, middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (targetArray[middle] == targetNum){
                flag = true;
                System.out.println("目标数: " + targetNum + " 在目标数组中, " + "下标为: " + middle);
                break;
            }else if(targetArray[middle] > targetNum){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
        }
        if (flag == false){
            System.out.println("没有找到");
        }
        return flag;
    }
}
