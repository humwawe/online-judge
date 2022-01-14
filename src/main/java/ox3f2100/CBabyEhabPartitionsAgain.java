package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBabyEhabPartitionsAgain {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        if (sum % 2 != 0) {
            out.println(0);
            return;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + a[i]] = true;
                }
            }
        }
        if (!dp[sum / 2]) {
            out.println(0);
            return;
        }
        out.println(1);
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                out.println(i + 1);
                return;
            }
            if (!dp[(sum - a[i]) / 2]) {
                out.println(i + 1);
                return;
            }
        }
    }
}
