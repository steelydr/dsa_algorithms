
//L(n)=L(n−1)+L(n−2)  with base cases:  L(0)=2,L(1)=1
package gfgbasicproblems;

import java.util.HashMap;

public class LucasNumbers {
    public static int lucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        return lucas(n - 1) + lucas(n - 2);
    }

     private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int lucasmemo(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        if (!memo.containsKey(n)) {
            memo.put(n, lucas(n - 1) + lucas(n - 2));
        }
        return memo.get(n);
    }

    public static int lucasdp(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 2;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int lucasso(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        int l0 = 2, l1 = 1;

        for (int i = 2; i <= n; i++) {
            int lNext = l0 + l1;
            l0 = l1;
            l1 = lNext;
        }

        return l1;
    }


    public static void main(String[] args) {
        System.out.println(lucas(10));
        System.out.println(lucasmemo(1));
        System.out.println(lucasdp(2));
        System.out.println(lucasso(3)); 
    }
}
