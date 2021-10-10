package codeforces.e115;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BGroups {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        int[][] mat = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (mat[k][i] == 1 && mat[k][j] == 1) {
                        cnt++;
                    } else if (mat[k][i] == 1) {
                        cnt1++;
                    } else if (mat[k][j] == 1) {
                        cnt2++;
                    }
                }
                if (cnt1 * 2 <= n && cnt2 * 2 <= n && cnt1 + cnt2 + cnt == n) {
                    out.println("YES");
                    return;
                }
            }
        }
        out.println("NO");
    }
}
