package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DCompleteTripartite {
  int N = 100010;
  int M = N * 6;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m;
  int[] col = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    col[1] = 1;
    for (int i = h[1]; i != -1; i = ne[i]) {
      int j = e[i];
      col[j] = 2;
    }
    int r = 0;
    for (int i = 1; i <= n; i++) {
      if (col[i] == 0) {
        col[i] = 1;
      } else {
        r = i;
      }
    }
    if (r == 0) {
      out.println(-1);
      return;
    }
    for (int i = h[r]; i != -1; i = ne[i]) {
      int j = e[i];
      if (col[j] == 2) {
        col[j] = 3;
      }
    }
    int[] cnt = new int[4];
    for (int i = 1; i <= n; i++) {
      cnt[col[i]]++;
    }

    for (int i = 1; i <= 3; i++) {
      if (cnt[i] == 0) {
        out.println(-1);
        return;
      }
    }
    if (cnt[1] * cnt[2] + cnt[2] * cnt[3] + cnt[1] * cnt[3] != m) {
      out.println(-1);
      return;
    }
    for (int u = 1; u <= n; u++) {
      int[] c = new int[4];
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        c[col[j]]++;
      }

      for (int i = 1; i <= 3; i++) {
        if (i == col[u]) {
          if (c[i] != 0) {
            out.println(-1);
            return;
          }
        } else {
          if (c[i] != cnt[i]) {
            out.println(-1);
            return;
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      out.print(col[i], "");
    }
    out.println();

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
