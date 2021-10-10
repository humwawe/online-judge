package codeforces.e115;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EStaircases {
    int n, m, q;

    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        int len = n * m;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + i;
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = Math.min(i - 1, j - 1);
                sum += (i - min + j - min) * 2;
            }
        }

        out.println(sum);
        q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
        }
    }
}
