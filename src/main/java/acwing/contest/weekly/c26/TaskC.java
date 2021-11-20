package acwing.contest.weekly.c26;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int N = (int) (1e5 + 5);
    int mod = (int) (1e9 + 7);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        int k = in.nextInt();
        int[] dp = new int[N];
        int[] sum = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1];
            if (i - k >= 0) {
                dp[i] = (dp[i] + dp[i - k]) % mod;
            }
            sum[i] = (sum[i - 1] + dp[i]) % mod;
        }

        for (int i = 0; i < t; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            out.println((sum[r] - sum[l - 1] + mod) % mod);
        }
    }
}
