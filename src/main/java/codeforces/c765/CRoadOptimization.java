package codeforces.c765;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CRoadOptimization {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int l = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        a[n] = l;
        int[] b = in.nextIntArray(n);
        int[][] dp = new int[n + 1][k + 1];
        int inf = 0x3f3f3f3f;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], inf);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int prev = i - 1; prev >= 0; prev--) {
                    int pk = j - (i - prev - 1);
                    if (pk >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[prev][pk] + (a[i] - a[prev]) * b[prev]);
                    }
                }
            }
        }
        int res = inf;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[n][i]);
        }
        out.println(res);
    }
}
