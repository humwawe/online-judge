package codeforces.c877;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ABlackboardList {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    if (a[0] < 0) {
      out.println(a[0]);
    } else {
      out.println(a[n - 1]);
    }
  }
}
