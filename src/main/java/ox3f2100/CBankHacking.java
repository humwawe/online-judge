package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CBankHacking {
  int N = 300010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] v = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int max = (int) -1e9;
    for (int i = 1; i <= n; i++) {
      v[i] = in.nextInt();
      max = Math.max(max, v[i]);
    }
    int x = 0;
    int y = 0;
    for (int i = 1; i <= n; i++) {
      if (v[i] == max) {
        x++;
      } else if (v[i] == max - 1) {
        y++;
      }
    }
    Arrays.fill(h, -1);
    idx = 0;

    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);

    }
    int res = max + 2;
    for (int u = 1; u <= n; u++) {
      boolean f = false;
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (v[j] == max) {
          x--;
          f = true;
        } else if (v[j] == max - 1) {
          y--;
        }
      }

      if (x == 0) {
        res = Math.min(res, max + 1);
      }
      if (v[u] == max && x == 1) {
        if (f) {
          res = Math.min(res, max + 1);
        } else if (y > 0) {
          res = Math.min(res, max + 1);
        } else {
          res = Math.min(res, max);
        }
      }


      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (v[j] == max) {
          x++;
        } else if (v[j] == max - 1) {
          y++;
        }
      }
    }
    out.println(res);

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
