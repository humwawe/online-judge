package codeforces.c767;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EGridXor {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int[][] cnt = new int[n][n];
        int res = 0;
        for (int j = 0; j < n; j++) {
            res ^= a[0][j];
            for (int[] f : fs) {
                int x = f[0];
                int y = j + f[1];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    cnt[x][y] ^= 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt[i - 1][j] == 0) {
                    res ^= a[i][j];
                    for (int[] f : fs) {
                        int x = i + f[0];
                        int y = j + f[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            cnt[x][y] ^= 1;
                        }
                    }
                }
            }
        }
        out.println(res);

    }
}
