package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DSoldierAndNumberGame {
    int N = (int) (5e6 + 5);
    int[] primes = new int[N];
    int[] dp = new int[N];
    int[] sum = new int[N];

    {
        getPrimes2(N - 1);
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + dp[i];
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        out.println(sum[a] - sum[b]);
    }

    void getPrimes2(int n) {
        boolean[] vis = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                primes[cnt++] = i;
                long t = i;
                while (t <= n) {
                    for (int j = (int) t; j <= n; j += t) {
                        dp[j]++;
                    }
                    t = t * i;
                }

            }
            for (int j = 0; primes[j] <= n / i; j++) {
                vis[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }

        }
    }
}
