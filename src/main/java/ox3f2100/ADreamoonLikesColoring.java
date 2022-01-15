package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ADreamoonLikesColoring {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long sum = 0;
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        for (int i = m - 1; i >= 0; i--) {
            if (n - a[i] < i) {
                out.println(-1);
                return;
            }
        }
        if (sum < n) {
            out.println(-1);
            return;
        }
        int idx = 1;
        for (int i = 0; i < m; i++) {
            out.print(idx, "");
            sum -= a[i];
            if (sum >= n - idx) {
                idx++;
            } else {
                idx = (int) (n - sum + 1);
            }
        }
    }
}
