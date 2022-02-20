package codeforces.c735;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DDiane {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 1) {
      out.println("a");
      return;
    }
    int b;
    if (n % 2 == 1) {
      b = n / 2 - 1;
      for (int i = 0; i < b; i++) {
        out.print('b');
      }
      out.print("ac");
      for (int i = 0; i < b + 1; i++) {
        out.print('b');
      }
    } else {
      b = n / 2 - 1;
      for (int i = 0; i < b; i++) {
        out.print('b');
      }
      out.print('a');
      for (int i = 0; i < b + 1; i++) {
        out.print('b');
      }
    }
    out.println();

  }
}
