package acwing.contest.weekly.c78;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.TreeSet;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
      a[i] = in.nextInt();
    }
    Arrays.sort(idx, (x, y) -> {
      int d = a[x] - a[y];
      if (d == 0) {
        return x - y;
      }
      return d;
    });

    TreeSet<Integer> set = new TreeSet<>();
    int[] res = new int[n];
    Arrays.fill(res, -1);
    for (int i = 0; i < n; i++) {
      int j = idx[i];
      if (set.size() >= 1) {
        int last = set.last();
        if (last > j) {
          res[j] = last - j - 1;
        }
      }
      set.add(j);
    }
    out.println(res);


  }
}
