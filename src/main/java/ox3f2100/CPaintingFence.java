package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPaintingFence {
  int n;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    out.println(dfs(0, n - 1));
  }

  private int dfs(int l, int r) {
    if (l == r) {
      return 1;
    }
    int min = (int) (1e9 + 5);
    for (int i = l; i <= r; i++) {
      min = Math.min(min, a[i]);
    }

    int x = min;
    for (int i = l; i <= r; i++) {
      a[i] -= min;
    }
    for (int i = l; i <= r; i++) {
      if (a[i] == 0) {
        continue;
      }
      int j = i;
      while (j + 1 <= r && a[j + 1] != 0) {
        j++;
      }
      x += dfs(i, j);
      i = j;
    }


    return Math.min(x, r - l + 1);
  }
}
