package codeforces.c874;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class BRestoreTheWeather {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = in.nextInt(n);
    Arrays.sort(b);
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> a[x]));
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[idx[i]] = b[i];
    }
    out.println(res);
  }
}
