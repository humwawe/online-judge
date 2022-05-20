package codeforces.c792;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DTraps {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
      b[i] = -a[i] + (n - i - 1);
    }
    Arrays.sort(b);
    for (int i = 0; i < k && b[i] - i < 0; i++) {
      sum += b[i] - i;
    }
    out.println(sum);
  }
}
