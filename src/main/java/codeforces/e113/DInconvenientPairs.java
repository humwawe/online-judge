package codeforces.e113;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DInconvenientPairs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
//        todo
        int[] row = new int[n];
        boolean[] vis1 = new boolean[(int) (1e6 + 5)];
//        row[n + 1] = (int) 1e6;
//        vis1[0] = true;
//        vis1[(int) 1e6] = true;

        int[] col = new int[m];
        boolean[] vis2 = new boolean[(int) (1e6 + 5)];
//        col[m + 1] = (int) 1e6;
//        vis2[0] = true;
//        vis2[(int) 1e6] = true;
        for (int i = 0; i < n; i++) {
            row[i] = in.nextInt();
            vis1[row[i]] = true;
        }
        for (int i = 0; i < m; i++) {
            col[i] = in.nextInt();
            vis2[col[i]] = true;
        }

        int[] cnt1 = new int[n + 2];
        int[] cnt2 = new int[m + 2];
        long res = 0;
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (vis1[x] && vis2[y]) {
                continue;
            }
            if (!vis1[x]) {
                int tmp = lowerBound(row, x);
                res += cnt1[tmp];
                cnt1[tmp]++;
            } else {
                int tmp = lowerBound(col, y);
                res += cnt2[tmp];
                cnt2[tmp]++;
            }
        }
        out.println(res);
    }

    int lowerBound(int[] a, int t) {
        int l = 0;
        int r = a.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
