package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPinkiePieEatsPattyCakes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int max = 0;
        int[] cnt = new int[n + 5];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            cnt[t]++;
            if (cnt[t] > max) {
                max = cnt[t];
            }
        }
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == max) {
                num++;
            }
        }
        out.println((n - max * num) / (max - 1) + num - 1);
    }
}
