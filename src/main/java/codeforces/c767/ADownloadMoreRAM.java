package codeforces.c767;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class ADownloadMoreRAM {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    Integer[] idx = new Integer[n];
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      idx[i] = i;
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> a[x]));
    int res = k;
    for (int i = 0; i < n; i++) {
      if (res >= a[idx[i]]) {
        res += b[idx[i]];
      } else {
        break;
      }
    }
    out.println(res);
  }
}
