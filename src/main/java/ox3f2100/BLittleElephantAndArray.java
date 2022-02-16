package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;


public class BLittleElephantAndArray {
    int N = (int) (1e5 + 5);
    int[] cnt = new int[N];
    int[][] sum = new int[N][505];
    int[] val = new int[505];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] > n) {
                continue;
            }
            cnt[a[i]]++;
        }
        int p = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] >= i) {
                val[++p] = i;
                for (int j = 0; j < n; j++) {
                    sum[j + 1][p] = sum[j][p] + (a[j] == i ? 1 : 0);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int res = 0;
            for (int j = 1; j <= p; j++) {
                if (sum[r][j] - sum[l - 1][j] == val[j]) {
                    res++;
                }
            }
            out.println(res);
        }
    }
}
