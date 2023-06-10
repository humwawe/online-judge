package atcoder.abc305;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Comparator;
import java.util.TreeSet;

public class DSleepLog {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = new int[n / 2 + 1];


    for (int i = 1; i <= n / 2; i++) {
      b[i] = a[i * 2] - a[i * 2 - 1];
    }

    long[] sum = new long[n / 2 + 2];
    TreeSet<int[]> set1 = new TreeSet<>(Comparator.comparingInt(x -> x[0]));
    TreeSet<int[]> set2 = new TreeSet<>(Comparator.comparingInt(x -> x[1]));
    set1.add(new int[]{0, 0, 0});
    set2.add(new int[]{0, 0, 0});
    for (int i = 1; i < n / 2 + 1; i++) {
      sum[i + 1] = sum[i] + b[i];
      set1.add(new int[]{a[i * 2 - 1], a[i * 2], i});
      set2.add(new int[]{a[i * 2 - 1], a[i * 2], i});
    }

    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();

      int[] floor = set1.floor(new int[]{l, l, 0});
      long res = 0;
      int[] ceiling = set2.ceiling(new int[]{r, r, 0});

      int s = floor[2] + 1;
      int t = ceiling[2] - 1;

      res += Math.max(0, sum[t + 1] - sum[s]);

      if (floor[0] == ceiling[0]) {
        res += r - l;
      } else {
        res += Math.max(0, r - ceiling[0]);
        res += Math.max(0, floor[1] - l);
      }

      out.println(res);
    }

  }
}
