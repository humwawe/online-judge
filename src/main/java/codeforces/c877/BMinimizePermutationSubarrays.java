package codeforces.c877;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMinimizePermutationSubarrays {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int one = 0, two = 0, max = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 1) {
        one = i;
      }
      if (a[i] == 2) {
        two = i;
      }
      if (a[i] == n) {
        max = i;
      }
    }

    if ((long) (one - max) * (two - max) < 0) {
      out.println(1, 1);
      return;
    }

    if ((long) (max - one) * (two - one) < 0) {
      out.println(one + 1, max + 1);
      return;
    }
    out.println(two + 1, max + 1);

  }
}
