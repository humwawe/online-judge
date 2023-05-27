package atcoder.abc303;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class BDiscord {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Set<Integer> set = new HashSet<>();
    int base = 100;
    for (int i = 0; i < m; i++) {
      int[] a = in.nextInt(n);
      for (int j = 1; j < n; j++) {
        set.add(a[j - 1] * base + a[j]);
        set.add(a[j] * base + a[j - 1]);
      }
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (!set.contains(i * base + j)) {
          res++;
        }
      }
    }
    out.println(res);
  }
}
