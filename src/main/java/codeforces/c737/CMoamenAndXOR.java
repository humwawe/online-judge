package codeforces.c737;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMoamenAndXOR {
    int n, k;
    int mod = 1000000007;
    long twoN;
    long tmp;
    Long[][] dp;
    int s = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();

        twoN = qmi(2, n, mod);
        tmp = qmi(2, n - 1, mod);
        s = 0;
        // 0 => equal
        dp = new Long[k + 1][2];
//        dp[0][0] = 1;
//        for (int i = 1; i <= k; i++) {
//            dp[i][1] = dp[i - 1][1] * twoN % mod;
//            if (n % 2 == 1) {
//                dp[i][0] = dp[i - 1][0] * (tmp + 1) % mod;
//            } else {
//                dp[i][0] = dp[i - 1][0] * (tmp - 1) % mod;
//                dp[i][1] = (dp[i][1] + dp[i - 1][0]) % mod;
//            }
//        }
//        out.println((dp[k][0] + dp[k][1]) % mod);
        out.println(dfs(0, 0));

    }

    private long dfs(int i, int lim) {
        if (dp[i][lim] != null) {
            return dp[i][lim];
        }
        if (i == k) {
            return dp[i][lim] = 1L;
        }
        if (lim == 0) {
            if (n % 2 == 1) {
                return dp[i][lim] = (tmp + 1) * dfs(i + 1, 0) % mod;
            } else {
                return dp[i][lim] = (dfs(i + 1, 0) * (tmp - 1) % mod + dfs(i + 1, 1)) % mod;
            }
        } else {
            return dp[i][lim] = twoN * dfs(i + 1, 1) % mod;
        }
    }


    int qmi(int m, int k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res % p;
    }
}
