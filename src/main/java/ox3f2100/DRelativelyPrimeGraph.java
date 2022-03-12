package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DRelativelyPrimeGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long m = in.nextInt();
    List<int[]> res = new ArrayList<>();
    if (m < n - 1) {
      out.println("Impossible");
      return;
    }
    int idx = 0;
    f:
    for (int s = 1; s < n; s++) {
      for (int i = s + 1; i <= n; i++) {
        if (gcd(s, i) == 1) {
          res.add(new int[]{s, i});
          idx++;
          if (idx == m) {
            break f;
          }
        }
      }
    }
    if (res.size() == m) {
      out.println("Possible");
      for (int[] p : res) {
        out.println(p[0], p[1]);
      }
    } else {
      out.println("Impossible");
    }
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
