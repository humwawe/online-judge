package nowcoder.courses.ab.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  int k;
  int[] a;
  int N = 10005;
  int[] mex = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(mex, -1);
    k = in.nextInt();
    a = new int[k];
    for (int i = 0; i < k; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < N; i++) {
      dfs(i);
    }
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int l = in.nextInt();
      int res = 0;
      for (int j = 0; j < l; j++) {
        int x = in.nextInt();
        res ^= mex[x];
      }
      if (res == 0) {
        out.print("L");
      } else {
        out.print("W");
      }
    }
  }

  private void dfs(int u) {
    if (mex[u] != -1) {
      return;
    }
    boolean[] vis = new boolean[k + 1];
    for (int i : a) {
      if (u - i >= 0) {
        dfs(u - i);
        vis[mex[u - i]] = true;
      }
    }

    for (int i = 0; i <= k; i++) {
      if (!vis[i]) {
        mex[u] = i;
        return;
      }
    }
  }
}
