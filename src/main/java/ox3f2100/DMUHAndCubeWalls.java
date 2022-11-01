package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DMUHAndCubeWalls {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int[] a1 = in.nextInt(n1);
    int[] a2 = in.nextInt(n2);
    if (n2 == 1) {
      out.println(n1);
      return;
    }
    int[] s = new int[n1 - 1];
    for (int i = 0; i < n1 - 1; i++) {
      s[i] = a1[i + 1] - a1[i];
    }
    int[] t = new int[n2 - 1];
    for (int i = 0; i < n2 - 1; i++) {
      t[i] = a2[i + 1] - a2[i];
    }
    out.println(helper(s, t));

  }

  void kmpPre(int[] x, int m, int[] next) {
    int i, j;
    j = next[0] = -1;
    i = 0;
    while (i < m) {
      while (-1 != j && x[i] != x[j]) {
        j = next[j];
      }
      next[++i] = ++j;
    }
  }


  public int helper(int[] y, int[] x) {
    int n = y.length;
    int m = x.length;

    int[] next = new int[x.length + 1];
    int i, j;
    int res = 0;
    kmpPre(x, m, next);
    i = j = 0;
    while (i < n) {
      while (-1 != j && y[i] != x[j]) {
        j = next[j];
      }
      i++;
      j++;
      if (j >= m) {
        res++;
        j = next[j];
      }
    }
    return res;
  }
}
