package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CArithmeticProgression {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    if (n == 1) {
      out.println(-1);
      return;
    }
    Arrays.sort(a);
    if (a[0] == a[n - 1]) {
      out.println(1);
      out.println(a[0]);
      return;
    }
    Set<Integer> set = new HashSet<>();
    if (n == 2) {
      int dist = a[1] - a[0];
      set.add(a[0] - dist);
      set.add(a[1] + dist);
      if (dist % 2 == 0) {
        set.add(a[0] + dist / 2);
      }
    } else {
      int[] d = new int[n - 1];
      for (int i = 0; i < n - 1; i++) {
        d[i] = a[i + 1] - a[i];
      }
      Arrays.sort(d);

      if (d[0] == d[n - 2]) {
        set.add(a[0] - d[0]);
        set.add(a[n - 1] + d[0]);
      } else if (d[0] == d[n - 3]) {
        int dis = d[0];
        for (int i = 0; i < n - 1; i++) {
          if (a[i + 1] - a[i] == 2 * dis && a[i + 1] - a[i] != dis) {
            set.add(a[i] + dis);
          }
        }
      }
    }
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    out.println(list.size());
    for (Integer integer : list) {
      out.print(integer, "");
    }


  }
}
