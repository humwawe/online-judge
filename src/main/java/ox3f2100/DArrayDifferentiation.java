package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DArrayDifferentiation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      set.add(a[i]);
    }
    for (int i = 0; i < 1 << n; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          sum += a[j];
        }
      }
      set.add(sum);
    }
    if (set.size() == 1 << n) {
      out.println("NO");
    } else {
      out.println("YES");
    }

  }
}
