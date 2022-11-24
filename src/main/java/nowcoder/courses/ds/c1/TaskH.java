package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskH {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] d1 = new long[n + 2];
    long[] d2 = new long[n + 2];
    long[] d3 = new long[n + 2];
    int mod = (int) (1e9 + 7);
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      int l = in.nextInt();
      if (t == 1) {
        d1[l] += 1;
      } else if (t == 2) {
        d2[l] += 1;
      } else {
        d3[l] += 1;
        d3[l + 1] += 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      d1[i] += d1[i - 1];
      d1[i] %= mod;
    }

    for (int i = 1; i <= n; i++) {
      d2[i] += d2[i - 1];
      d2[i] %= mod;
    }
    for (int i = 1; i <= n; i++) {
      d2[i] += d2[i - 1];
      d2[i] %= mod;
    }

    for (int i = 1; i <= n; i++) {
      d3[i] += d3[i - 1];
      d3[i] %= mod;
    }
    for (int i = 1; i <= n; i++) {
      d3[i] += d3[i - 1];
      d3[i] %= mod;
    }

    for (int i = 1; i <= n; i++) {
      d3[i] += d3[i - 1];
      d3[i] %= mod;
    }

    for (int i = 1; i <= n; i++) {
      out.print((d1[i] + d2[i] + d3[i]) % mod, "");
    }
    out.println();


  }
}
