package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ETreeShuffling {
  int N = 200010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int[] a = new int[N];
  int[] b = new int[N];
  int[] c = new int[N];
  int n;
  long ans = 0;
  int[][] cnt = new int[N][2];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
      c[i] = in.nextInt();
    }
    Arrays.fill(h, -1);
    idx = 0;
    for (int i = 0; i < n - 1; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      add(x, y);
      add(y, x);
    }

    dfs(1, 1);
    if (cnt[1][0] != 0 || cnt[1][1] != 0) {
      out.println(-1);
      return;
    }
    out.println(ans);
  }

  private void dfs(int u, int p) {
    a[u] = Math.min(a[u], a[p]);
    if (b[u] != c[u]) {
      cnt[u][c[u]]++;
    }
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      cnt[u][0] += cnt[j][0];
      cnt[u][1] += cnt[j][1];
    }
    int t = Math.min(cnt[u][0], cnt[u][1]);
    ans += (long) a[u] * t * 2;
    cnt[u][0] -= t;
    cnt[u][1] -= t;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
