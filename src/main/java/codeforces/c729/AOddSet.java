package codeforces.c729;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AOddSet {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int t = 0;
    for (int i = 0; i < 2 * n; i++) {
      int a = in.nextInt();
      if (a % 2 == 1) {
        t++;
      }
    }
    if (t == n) {
      out.println("Yes");
    } else {
      out.println("No");
    }
  }
}
