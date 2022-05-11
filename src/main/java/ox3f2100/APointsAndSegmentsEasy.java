package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class APointsAndSegmentsEasy {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Integer[] idx = new Integer[n];
    int q = in.nextInt();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> a[x]));
    int cur = 1;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[idx[i]] = cur ^ 1;
      cur = cur ^ 1;
    }
    out.println(res);
  }
}
