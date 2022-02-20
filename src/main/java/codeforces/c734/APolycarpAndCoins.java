package codeforces.c734;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APolycarpAndCoins {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int t = n % 3;
    int res = n / 3;
    if (t == 0) {
      out.println(res + " " + res);
    } else if (t == 1) {
      out.println((res + 1) + " " + res);
    } else {
      out.println(res + " " + (res + 1));
    }
  }
}
