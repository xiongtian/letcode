package m12;

/**
 * @Author xiongtian
 * @Date 2020/12/11 9:18
 * @Version 1.0
 * <p>
 * <p>
 * 递归练习
 */

public class TestRecursive {
    public static void main(String[] args) {
        TestRecursive t = new TestRecursive();

        // 递归
        System.out.println(t.addAll(5));
        System.out.println(t.factorial(5));
        System.out.println(t.exponentiating(0,0));
        // 斐波那契数列
        System.out.println(t.fib(5));
        System.out.println(t.fib1(5));
    }


    /**
     * 累加
     *
     * @param n
     * @return
     */
    public int addAll(int n) {
        if (n == 0) {
            return 0;
        }
        return n + addAll(n - 1);
    }

    /**
     * 阶乘
     */
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(--n);
    }

    /**
     * 求幂
     * @param n
     * @param m
     * @return
     */
    public int exponentiating(int n, int m) {
        if (m == 0) {
            return 1;
        }
        if (m == 1) {
            return n;
        }
        return n * exponentiating(n, m - 1);
    }

    /**
     * 0 1 1 2 3 5 8 13 21 34
     * 斐波那契数列 fibonacci
     * 递归实现
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 斐波那契数列的其他实现
     * 提交git的时候使用普通递归的方式，会超时编译不通过
     * 这里使用数组的方式进行存储优化
     */
    public int fib1(int n) {
        int[] flag = new int[n + 1];
        return dp(n, flag);
    }

    private int dp(int n, int[] flag) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        flag[n] = flag[n] == 0 ? (dp(n - 1, flag) + dp(n - 2, flag)) : flag[n];
        return flag[n];
    }

    /**
     * 为了符合letcode的时间复杂度，另一种使用动态规划的解题方法
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}
