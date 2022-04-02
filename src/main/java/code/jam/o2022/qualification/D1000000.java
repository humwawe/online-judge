package code.jam.o2022.qualification;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class D1000000 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] >= res + 1) {
        res++;
      }
    }
    out.printf("Case #%d: %d\n", testNumber, res);
  }
}
