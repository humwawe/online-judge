package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BKyoyaAndPermutation {
  int N = 55;
  long[] d = new long[N];
  int[] res = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long k = in.nextLong();

    d[1] = 1;
    d[2] = 1;
    for (int i = 3; i < N; i++) {
      d[i] = d[i - 2] + d[i - 1];
    }
    dfs(1, n, k);
    for (int i = 1; i <= n; i++) {
      out.print(res[i], "");
    }
  }

  private void dfs(int l, int r, long k) {
    int len = r - l + 1;
    if (len == 0) {
      return;
    }
    if (len == 1) {
      res[l] = l;
      return;
    }
    if (k > d[len]) {
      res[l] = l + 1;
      res[l + 1] = l;
      dfs(l + 2, r, k - d[len]);
    } else {
      res[l] = l;
      dfs(l + 1, r, k);
    }

  }
}
