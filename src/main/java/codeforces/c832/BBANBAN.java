package codeforces.c832;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BBANBAN {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n % 2 == 0) {
      out.println(n / 2);
    } else {
      out.println(n / 2 + 1);
    }
    for (int i = 0, j = n - 1; i <= j; i++, j--) {
      out.println(i * 3 + 1, j * 3 + 3);
    }
  }
}
