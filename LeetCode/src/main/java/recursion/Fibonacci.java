package recursion;

/**
 * @author rjjerry
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciDptable(10));
    }
    //递归的 fibonacci
    public static int fibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    //备忘录的 fibonacci
    public static int fibonacciMemo(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];
        return fibonacciMemoHelper(memo, n);
    }

    //备忘录 辅助函数
    public static int fibonacciMemoHelper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacciMemoHelper(memo, n - 1) + fibonacciMemoHelper(memo, n - 2);
        return memo[n];
    }

    //递推公式
    public static int fibonacciDptable(int n ){
        int[] dpTable = new int[n + 1];
        dpTable[1] = dpTable[2] = 1;
        for (int i = 3; i <=  n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n];
    }
}
