package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CUncleBogdanAndCountryHappiness {
  int[] h;
  int[] e;
  int[] ne;
  int idx;
  int n, m;
  int[] a;
  int[] b;
  int[] good, bad, size;
  boolean ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    h = new int[n + 5];
    e = new int[(n + 5) * 2];
    ne = new int[(n + 5) * 2];
    Arrays.fill(h, -1);
    idx = 0;
    a = new int[n + 5];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    b = new int[n + 5];
    for (int i = 1; i <= n; i++) {
      b[i] = in.nextInt();
    }
    good = new int[n + 5];
    bad = new int[n + 5];
    size = new int[n + 5];
    for (int i = 0; i < n - 1; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      add(x, y);
      add(y, x);
    }
    ans = true;
    dfs(1, 1);
    if (ans) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }

  private void dfs(int u, int p) {

    size[u] += a[u];
    int sumG = 0;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      size[u] += size[j];
      sumG += good[j];
    }

    if ((size[u] + b[u]) % 2 != 0) {
      ans = false;
      return;
    }
    if ((size[u] - b[u]) % 2 != 0) {
      ans = false;
      return;
    }

    good[u] = (size[u] + b[u]) / 2;
    bad[u] = (size[u] - b[u]) / 2;

    if (good[u] < 0 || bad[u] < 0) {
      ans = false;
    }

    if (good[u] < sumG) {
      ans = false;
    }

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
