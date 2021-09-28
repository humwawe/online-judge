package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class E2ArrayOptimizationByDeque {
    int n;
    int len;
    Integer[] b;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        len = 0;
        b = new Integer[n];
        Arrays.fill(t, 0);
        long[][] dp = new long[n + 1][2];
        int[] a = in.nextIntArray(n);
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        discrete(b);
        int[] vmax = new int[n + 1];
        int[] vmin = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int idx = find(a[i - 1]) + 1;
            vmin[i] = sum(idx - 1);
            vmax[i] = sum(n) - sum(idx);
            add(idx, 1);
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = vmax[i] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = vmin[i] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        out.println(Math.min(dp[n][0], dp[n][1]));
    }

    public int find(int x) {
        return Arrays.binarySearch(b, 0, len, x);
    }

    void discrete(Integer[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || !a[i].equals(a[i - 1])) {
                a[len++] = a[i];
            }
        }
    }

    int N = (int) (2e5 + 5);
    int[] t = new int[N];


    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) {
            t[i] += c;
        }
    }

    int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += t[i];
        }
        return res;
    }
}
