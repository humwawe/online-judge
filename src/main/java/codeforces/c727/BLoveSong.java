package codeforces.c727;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BLoveSong {
    int n;
    int q;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        q = in.nextInt();
        String s = in.nextString();
        int[][] cntSum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                cntSum[i + 1][j] = cntSum[i][j];
                if (s.charAt(i) - 'a' == j) {
                    cntSum[i + 1][j] += 1;
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int l = in.nextInt() - 1;
            int r = in.nextInt();
            long res = 0;
            for (int j = 0; j < 26; j++) {
                res += (cntSum[r][j] - cntSum[l][j]) * (j + 1);
            }
            out.println(res);
        }
    }
}
