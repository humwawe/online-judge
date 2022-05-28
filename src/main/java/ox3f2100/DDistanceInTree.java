package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DDistanceInTree {
  int N = 50010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, k;
  int K = 505;
  int[][] cnt = new int[N][K];
  long res = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    k = in.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }

    dfs(1, 0);
    out.println(res);
  }


  private void dfs(int u, int p) {
    cnt[u][0] = 1;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }

      dfs(j, u);

      for (int l = 0; l < k; l++) {
        res += cnt[j][l] * cnt[u][k - l - 1];
      }

      for (int l = 1; l <= k; l++) {
        cnt[u][l] += cnt[j][l - 1];
      }
    }

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
