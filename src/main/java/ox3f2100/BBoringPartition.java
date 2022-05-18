package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class BBoringPartition {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int h = in.nextInt();
    int[] a = new int[n];
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      idx[i] = i;
    }
    if (n == 2) {
      out.println(0);
      out.println(1, 1);
      return;
    }

    Arrays.sort(idx, Comparator.comparingInt(x -> a[x]));

    int res1 = a[idx[n - 1]] + a[idx[n - 2]] - a[idx[0]] - a[idx[1]];
    int res2 = Math.max(a[idx[n - 1]] + a[idx[n - 2]], a[idx[n - 1]] + a[idx[0]] + h) - Math.min(a[idx[0]] + a[idx[1]] + h, a[idx[1]] + a[idx[2]]);
    out.println(Math.min(res1, res2));
    if (res1 <= res2) {
      for (int i = 0; i < n; i++) {
        out.print(1, "");
      }
    } else {
      for (int i = 0; i < n; i++) {
        if (idx[0] == i) {
          out.print(1, "");
        } else {
          out.print(2, "");
        }
      }
    }
  }
}
