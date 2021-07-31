package codeforces.e112;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CCoinRows {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int m = in.nextInt();
        int[][] a = new int[2][m + 1];
        int[][] sum = new int[2][m + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = in.nextInt();
                sum[i][j] = sum[i][j - 1] + a[i][j];
            }
        }
        int res = (int) 2e9 + 5;
        for (int i = 1; i <= m; i++) {
            res = Math.min(res, Math.max(sum[0][m] - sum[0][i], sum[1][i - 1]));
        }
        out.println(res);
    }
}
