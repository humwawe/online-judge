package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DUnbearableControversyOfBeing {
  int N = 3005;
  int M = (int) (3e5 + 5);
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int[][] cnt = new int[N][N];


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    int n = in.nextInt();
    int m = in.nextInt();

    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
    }

    long res = 0;
    for (int u = 1; u <= n; u++) {
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        for (int k = h[j]; k != -1; k = ne[k]) {
          int v = e[k];
          if (u != v) {
            cnt[u][v]++;
          }
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        res += (long) cnt[i][j] * (cnt[i][j] - 1) / 2;
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
