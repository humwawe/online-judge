package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCowAndSnacks {
  int[] p = new int[(int) (1e5 + 5)];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    for (int i = 0; i <= n; i++) {
      p[i] = i;
    }
    int[][] a = new int[k][2];
    for (int i = 0; i < k; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    int res = 0;
    for (int i = 0; i < k; i++) {
      int x = find(a[i][0]);
      int y = find(a[i][1]);
      if (x != y) {
        p[x] = y;
      } else {
        res++;
      }
    }
    out.println(res);
  }

  private int find(int x) {
    if (p[x] == x) {
      return x;
    }
    return p[x] = find(p[x]);
  }
}
