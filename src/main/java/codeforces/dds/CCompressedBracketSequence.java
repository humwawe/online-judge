package codeforces.dds;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CCompressedBracketSequence {
    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        long[] dp = new long[n];
        long res = 0;

        for (int i = 1; i < n; i += 2) {
            if (a[i] < a[i - 1]) {
                dp[i] = a[i];
                a[i - 1] -= a[i];
                a[i] = 0;
            } else if (a[i] == a[i - 1]) {
                dp[i] = a[i];
                a[i] = 0;
                a[i - 1] = 0;
                if (i - 2 >= 0 && a[i - 2] >= 0) {
                    dp[i] += dp[i - 2];
                }
            } else {
                dp[i] = a[i - 1];
                a[i] -= a[i - 1];
                a[i - 1] = 0;
                int j = i - 2;
                boolean f = true;
                for (; j >= 0; j -= 2) {
                    if (a[j] == -1) {
                        break;
                    }
                    if (f) {
                        dp[i] += dp[j];
                        f = false;
                    }

                    if (a[i] == 0) {
                        break;
                    }
                    if (a[i] >= a[j - 1]) {
                        if (a[j - 1] > 0) {
                            f = true;
                        }
                        a[i] -= a[j - 1];
                        dp[i] += a[j - 1];
                        a[j - 1] = 0;
                    } else {
                        dp[i] += a[i];
                        a[i] = 0;
                        a[j - 1] -= a[i];
                        f = true;
                    }
                }

                if (a[i] > 0) {
                    a[i] = -1;
                }
            }

            res += dp[i];
        }
        out.println(res);
    }
}
