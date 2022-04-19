package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BGameGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int x = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      x ^= a[i];
    }
    if (x == 0) {
      out.println("DRAW");
      return;
    }

    for (int i = 30; i >= 0; i--) {
      if ((x >> i & 1) == 1) {
        int[] cnt = new int[2];
        for (int j : a) {
          cnt[j >> i & 1]++;
        }
        if (cnt[1] % 4 == 3 && cnt[0] % 2 == 0) {
          out.println("LOSE");
        } else {
          out.println("WIN");
        }
        return;
      }
    }
  }
}
