package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class DDashaAndVeryDifficultProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int l = in.nextInt();
    int r = in.nextInt();
    int[] a = new int[n];
    int[] c = new int[n];
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt();
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> c[x]));
    int[] b = new int[n];
    int last = -a[idx[0]] + l;
    for (int i = 0; i < n; i++) {
      int index = idx[i];
      b[index] = Math.max(last + a[index], l);
      last = b[index] - a[index] + 1;
      if (b[index] > r) {
        out.println(-1);
        return;
      }
    }
    out.println(b);
  }
}
