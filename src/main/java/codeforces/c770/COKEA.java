package codeforces.c770;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class COKEA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] res = new int[n][k];
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * k; i += 2) {
            res[x][y] = i;
            y++;
            if (y == k) {
                x++;
                y = 0;
            }
        }
        if (y != 0) {
            out.println("NO");
            return;
        }
        for (int i = 2; i <= n * k; i += 2) {
            res[x][y] = i;
            y++;
            if (y == k) {
                x++;
                y = 0;
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                out.print(res[i][j] + " ");
            }
            out.println();
        }
    }
}
