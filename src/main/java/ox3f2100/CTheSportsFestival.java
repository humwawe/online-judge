package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CTheSportsFestival {
  long[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    memo = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(memo[i], -1);
    }
    out.println(helper(a, 0, n - 1));
  }

  private long helper(int[] a, int i, int j) {
    if (i == j) {
      return 0;
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    return memo[i][j] = Math.min(helper(a, i + 1, j), helper(a, i, j - 1)) + a[j] - a[i];
  }


}
