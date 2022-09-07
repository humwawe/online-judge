package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DChoosingCapitalForTreeland {
  int N = (int) (2e5 + 5);
  int M = (int) (4e5 + 5);

  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  long[] w = new long[M];
  int idx;

  int n;
  int[] dp = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b, 0);
      add(b, a, 1);
    }
    dfs(1, 1);
    dfs2(1, 1);
    int min = (int) 1e8;
    for (int i = 1; i <= n; i++) {
      min = Math.min(min, dp[i]);
    }
    out.println(min);
    for (int i = 1; i <= n; i++) {
      if (dp[i] == min) {
        out.print(i, "");
      }
    }
  }

  void dfs2(int u, int p) {
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      if (w[i] == 0) {
        dp[j] = dp[u] + 1;
      } else {
        dp[j] = dp[u] - 1;
      }

      dfs2(j, u);
    }
  }

  void dfs(int u, int p) {
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      dp[u] += dp[j] + w[i];
    }
  }

  void add(int a, int b, int v) {
    e[idx] = b;
    w[idx] = v;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
