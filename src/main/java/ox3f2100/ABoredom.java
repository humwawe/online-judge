package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ABoredom {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int N = (int) (1e5 + 5);
    int[] cnt = new int[N];
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      cnt[a[i]]++;
    }
    a = uniq(a);
    long[] dp = new long[a.length];
    dp[0] = (long) a[0] * cnt[a[0]];
    for (int i = 1; i < a.length; i++) {
      if (a[i] == a[i - 1] + 1) {
        dp[i] = Math.max(dp[i - 1], (long) a[i] * cnt[a[i]] + (i - 2 >= 0 ? dp[i - 2] : 0));
      } else {
        dp[i] = dp[i - 1] + (long) a[i] * cnt[a[i]];
      }
    }
    out.println(dp[a.length - 1]);
  }

  int[] uniq(int[] a) {
    Arrays.sort(a);
    int p = 0;
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] != a[i - 1]) {
        a[p++] = a[i];
      }
    }
    return Arrays.copyOf(a, p);
  }
}
