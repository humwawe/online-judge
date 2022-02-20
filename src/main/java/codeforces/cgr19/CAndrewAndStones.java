package codeforces.cgr19;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAndrewAndStones {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n - 2];
    in.nextInt();
    for (int i = 0; i < n - 2; i++) {
      a[i] = in.nextInt();
    }
    in.nextInt();
    if (n == 3) {
      if (a[0] % 2 == 1) {
        out.println(-1);
        return;
      }
    }
    long cnt = 0;
    long res = 0;
    for (int i = 0; i < n - 2; i++) {
      cnt += a[i] / 2;
      res += a[i] / 2;
      a[i] %= 2;
    }
    for (int i = 0; i < n - 2; i++) {
      if (a[i] != 0) {
        if (cnt > 0) {
          res++;
        } else {
          out.println(-1);
          return;
        }

      }
    }
    out.println(res);
  }
}
