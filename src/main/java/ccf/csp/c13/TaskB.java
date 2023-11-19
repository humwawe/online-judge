package ccf.csp.c13;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int l = in.nextInt();
    int t = in.nextInt();
    int[] a = in.nextInt(n);
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> a[x]));

    for (int i = 0; i < n; i++) {
      int f = 1;
      for (int j = 0; j < t; j++) {
        a[i] = a[i] + f;
        if (a[i] >= l) {
          f = -1;
        }
        if (a[i] == 0) {
          f = 1;
        }
      }
    }

    Arrays.sort(a);
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[idx[i]] = a[i];
    }
    for (int i = 0; i < n; i++) {
      out.print(b[i], "");
    }
    out.println();
  }


}
