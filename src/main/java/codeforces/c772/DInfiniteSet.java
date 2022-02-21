package codeforces.c772;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DInfiniteSet {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt();
    int mod = (int) (1e9 + 7);
    int[] a = new int[n];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      set.add(a[i]);
    }
    int[] dp = new int[p + 100];
    for (int i = 0; i < n; i++) {
      int len = bitLength(a[i]);
      boolean f = false;
      while (a[i] > 0) {
        if (a[i] % 2 == 1) {
          a[i] = (a[i] - 1) / 2;
        } else if (a[i] % 4 == 0) {
          a[i] = a[i] / 4;
        } else {
          break;
        }
        if (set.contains(a[i])) {
          f = true;
          break;
        }
      }
      if (!f) {
        dp[len]++;
      }
    }

    long sum = dp[1];
    for (int i = 2; i <= p; i++) {
      dp[i] = (dp[i] + (dp[i - 1] + dp[i - 2]) % mod) % mod;
      sum += dp[i];
      sum %= mod;
    }
    out.println(sum);
  }

  int bitLength(long num) {
    int c = 0;
    for (; num > 0; num >>= 1) {
      ++c;
    }
    return c;
  }
}
