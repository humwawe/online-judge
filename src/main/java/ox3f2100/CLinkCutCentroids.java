package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CLinkCutCentroids {
  int N = 100010;
  int M = N * 2;
  int[] h;
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] d;
  int[] size;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    h = new int[n + 1];
    Arrays.fill(h, -1);
    d = new int[n + 1];
    size = new int[n + 1];
    idx = 0;

    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    dfs(1, 1);
    int minI = 0;
    int minJ = 0;
    int min = (int) 1e8;
    for (int i = 1; i <= n; i++) {
      if (d[i] < min) {
        minI = i;
        minJ = i;
        min = d[i];
      } else if (d[i] == min) {
        minJ = i;
      }
    }
    if (minI == minJ) {
      out.println(e[0], e[1]);
      out.println(e[0], e[1]);
    } else {
      int i = h[minI];
      for (; i != -1; i = ne[i]) {
        if (e[i] != minJ) {
          out.println(e[i ^ 1], e[i]);
          break;
        }
      }
      out.println(minJ, e[i]);
    }
  }

  private void dfs(int u, int p) {
    size[u] = 1;
    d[u] = 0;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      size[u] += size[j];
      d[u] = Math.max(d[u], size[j]);
    }
    d[u] = Math.max(d[u], n - size[u]);
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
