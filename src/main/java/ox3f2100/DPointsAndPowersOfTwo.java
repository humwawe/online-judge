package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DPointsAndPowersOfTwo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      set.add(a[i]);
    }
    int[] tmp = new int[31];
    tmp[0] = 1;
    for (int i = 1; i < 31; i++) {
      tmp[i] = tmp[i - 1] * 2;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 30; j++) {
        int x = a[i] + tmp[j];
        int y = a[i] + tmp[j + 1];
        if (set.contains(x) && set.contains(y)) {
          out.println(3);
          out.println(a[i], x, y);
          return;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 31; j++) {
        int x = a[i] + tmp[j];
        if (set.contains(x)) {
          out.println(2);
          out.println(a[i], x);
          return;
        }
      }
    }
    out.println(1);
    out.println(a[0]);
  }
}
