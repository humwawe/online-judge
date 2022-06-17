package codeforces.c800;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CDirectionalIncrease {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    long sum = 0;
    boolean f = false;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
      if (a[i] != 0) {
        f = true;
      }
    }
    if (!f) {
      out.println("Yes");
      return;
    }

    if (a[0] <= 0 || a[n - 1] > 0 || sum != 0) {
      out.println("No");
      return;
    }


    sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
      if (sum < 0) {
        out.println("No");
        return;
      }
      if (sum == 0) {
        while (i + 1 < n) {
          if (a[i + 1] != 0) {
            out.println("No");
            return;
          }
          i++;
        }
      }
    }

    out.println("Yes");

  }
}
