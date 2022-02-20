package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ASumInTheTree {
  int N = 100010;
  int M = N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] s = new int[N];
  long res = 0;
  boolean f = true;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    for (int i = 2; i <= n; i++) {
      int a = in.nextInt();
      add(a, i);
    }
    for (int i = 1; i <= n; i++) {
      s[i] = in.nextInt();
    }
    dfs(1, 1, 0);
    if (f) {
      out.println(res);
    } else {
      out.println(-1);
    }
  }

  private void dfs(int u, int hei, long v) {

    long tmp = Long.MAX_VALUE;
    if (hei % 2 != 0) {
      if (s[u] < v) {
        f = false;
        return;
      }
      res += s[u] - v;
    } else {
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        tmp = Math.min(tmp, s[j] - v);
        if (s[j] < v) {
          f = false;
          return;
        }
      }
      if (tmp == Long.MAX_VALUE) {
        tmp = 0;
      }
      res += tmp;
    }
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      long nv = s[u];
      if (nv == -1) {
        nv = v + tmp;
      }
      dfs(j, hei + 1, nv);
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
