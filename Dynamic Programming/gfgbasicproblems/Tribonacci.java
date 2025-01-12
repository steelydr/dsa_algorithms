/*  T(n)=T(n−1)+T(n−2)+T(n−3)
where 
 T(0)=0, 
T(1)=1, and 
T(2)=1.  */
package gfgbasicproblems;

import java.util.HashMap;

public class Tribonacci {

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int tribonaccimemo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        }
        return memo.get(
                n);
    }

    public static int tribonaccidp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static int tribonacciso(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int t0 = 0, t1 = 1, t2 = 1;

        for (int i = 3; i <= n; i++) {
            int tNext = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tNext;
        }

        return t2;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(10));
        System.out.println(tribonaccimemo(1));
        System.out.println(tribonaccidp(2));
        System.out.println(tribonacciso(3));

    }
}
