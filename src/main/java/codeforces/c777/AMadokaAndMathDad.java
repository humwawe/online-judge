package codeforces.c777;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMadokaAndMathDad {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = n % 3;
    if (x == 0) {
      StringBuilder sb = new StringBuilder();
      int a = 2;
      while (n > 0) {
        n -= a;
        sb.append(a);
        a = 3 - a;
      }
      out.println(sb.toString());
    } else if (x == 1) {
      StringBuilder sb = new StringBuilder();
      int a = 1;
      while (n > 0) {
        n -= a;
        sb.append(a);
        a = 3 - a;
      }
      out.println(sb.toString());
    } else {
      StringBuilder sb = new StringBuilder();
      int a = 2;
      while (n > 0) {
        n -= a;
        sb.append(a);
        a = 3 - a;
      }
      out.println(sb.toString());
    }

  }
}
