package atcoder.abc311;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CFindIt {
  int n;
  int[] a;
  int[] pre;
  boolean[] vis;
  List<Integer> res = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    pre = new int[n];
    vis = new boolean[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt() - 1;
    }
    dfs(0);
    Collections.reverse(res);
    out.println(res.size());
    out.println(res);
  }

  private void dfs(int i) {
    if (vis[i]) {
      int j = i;
      res.add(i + 1);
      while (pre[j] != i) {
        res.add(pre[j] + 1);
        j = pre[j];
      }
      return;
    }
    vis[i] = true;
    pre[a[i]] = i;
    dfs(a[i]);
  }
}
