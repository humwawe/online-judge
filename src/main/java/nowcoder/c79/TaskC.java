package nowcoder.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);


    int res = 0;

    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        if (i > 0) {
          res = Math.max(res, a[i - 1]);
        }
        if (i < n - 1) {
          res = Math.max(res, a[i + 1]);
        }
      }
    }
    Set<Integer> set = new HashSet<>();
    for (int i : a) {
      set.add(i);
    }
    if (set.size() == 1 && set.contains(0)) {
      out.println(0);
      return;
    }

    for (int i = 0; ; i++) {
      if (!set.contains(i)) {
        res = Math.max(res, i);
        break;
      }
    }
    out.println(res);
  }
}
