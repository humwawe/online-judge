package codeforces.e111;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMaximumCostDeletion {
    int a, b;
    int n;
    String s;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        s = in.nextString();
        if (b >= 0) {
            out.println(a * n + b * n);
            return;
        }
        int[][] min = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            min[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    min[i][j] = min[i][j - 1];
                } else {
                    int minIj = 100000000;
                    for (int k = i; k < j; k++) {
                        if (min[i][k] + min[k + 1][j] < minIj) {
                            minIj = min[i][k] + min[k + 1][j];
                        }
                    }
                    min[i][j] = minIj;
                }
            }
        }
        out.println(a * n + b * min[0][n - 1]);

    }
}
