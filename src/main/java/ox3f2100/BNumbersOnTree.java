package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.LinkedList;

public class BNumbersOnTree {
  int N = 2010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] a;
  boolean f = true;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    a = new int[n + 1];
    int root = 0;
    for (int i = 1; i <= n; i++) {
      int x = in.nextInt();
      if (x == 0) {
        root = i;
      } else {
        add(x, i);
        add(i, x);
      }
      a[i] = in.nextInt();
    }
    LinkedList<Integer> list = dfs(root, root);
    if (!f) {
      out.println("NO");
      return;
    }

    for (int i = 1; i <= n; i++) {
      a[list.get(i - 1)] = i;
    }
    out.println("YES");
    for (int i = 1; i <= n; i++) {
      out.print(a[i], "");
    }
  }

  private LinkedList<Integer> dfs(int u, int p) {
    LinkedList<Integer> res = new LinkedList<>();
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      res.addAll(dfs(j, u));
    }
    if (res.size() < a[u]) {
      f = false;
      return new LinkedList<>();
    }
    res.add(a[u], u);
    return res;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
