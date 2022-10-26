package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Comparator;
import java.util.TreeSet;

public class DShurikens {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[2 * n];
    TreeSet<Integer> set = new TreeSet<>();
    TreeSet<int[]> set2 = new TreeSet<>(Comparator.comparingInt(x -> x[0]));
    for (int i = 0; i < n * 2; i++) {
      char c = in.nextCharacter();
      if (c == '+') {
        set.add(i);
      } else {
        int x = in.nextInt();
        a[i] = -x;
        set2.add(new int[]{x, i});
      }
    }
    TreeSet<int[]> res = new TreeSet<>(Comparator.comparingInt(x -> x[0]));
    for (int[] ints : set2) {
      int v = ints[0];
      int idx = ints[1];
      Integer floor = set.floor(idx);
      if (floor == null) {
        out.println("NO");
        return;
      }
      res.add(new int[]{floor, v});
      set.remove(floor);
    }

    for (int[] re : res) {
      a[re[0]] = re[1];
    }
    set.clear();
    for (int i = 0; i < 2 * n; i++) {
      if (a[i] > 0) {
        set.add(a[i]);
      } else {
        Integer integer = set.pollFirst();
        if (integer == null || integer != -a[i]) {
          out.println("NO");
          return;
        }
      }
    }

    out.println("YES");
    for (int i = 0; i < 2 * n; i++) {
      if (a[i] > 0) {
        out.print(a[i], "");
      }
    }
    out.println();
  }
}
