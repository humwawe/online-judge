package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BZuma {
  int n;
  int[] a;
  int[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    memo = new int[n][n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      Arrays.fill(memo[i], -1);
    }
    out.println(dfs(0, n - 1));

  }

  private int dfs(int l, int r) {
    if (l == r) {
      return 1;
    }
    if (l + 1 == r) {
      if (a[l] == a[r]) {
        return 1;
      } else {
        return 2;
      }
    }
    if (memo[l][r] != -1) {
      return memo[l][r];
    }

    int min = (int) 1e8;
    if (a[l] == a[r]) {
      min = dfs(l + 1, r - 1);
    }
    for (int i = l; i < r; i++) {
      if (a[l] == a[i]) {
        min = Math.min(min, dfs(l, i) + dfs(i + 1, r));
      }
    }
    return memo[l][r] = min;
  }
}
