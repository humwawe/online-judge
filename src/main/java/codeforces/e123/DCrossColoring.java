package codeforces.e123;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DCrossColoring {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int mod = 998244353;
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int q = in.nextInt();
    int[] row = new int[q];
    int[] col = new int[q];
    for (int i = 0; i < q; i++) {
      row[i] = in.nextInt();
      col[i] = in.nextInt();
    }
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    long res = 1;
    for (int i = q - 1; i >= 0; i--) {
      int x = row[i];
      int y = col[i];
      boolean f = false;
      if (set1.contains(x) && set2.contains(y)) {
        f = true;
      }
      if (!set2.contains(y) && set1.size() == n) {
        f = true;
      }
      if (!set1.contains(x) && set2.size() == m) {
        f = true;
      }

      if (!f) {
        res *= k;
        res %= mod;
      }
      set1.add(x);
      set2.add(y);
    }
    out.println(res);
  }
}
