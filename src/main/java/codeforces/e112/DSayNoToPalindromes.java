package codeforces.e112;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DSayNoToPalindromes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        String s = in.nextString();
        String[] tmp = new String[]{"abc", "acb", "bac", "bca", "cab", "cba"};
        int[][] sum = new int[6][n + 1];
        for (int i = 0; i < 6; i++) {
            String t = tmp[i];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                sum[i][j + 1] = sum[i][j];
                if (s.charAt(j) != t.charAt(idx)) {
                    sum[i][j + 1] += 1;
                }
                idx++;
                if (idx >= 3) {
                    idx = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int res = (int) 1e6;
            for (int j = 0; j < 6; j++) {
                res = Math.min(res, sum[j][r] - sum[j][l - 1]);
            }
            out.println(res);
        }

    }
}
