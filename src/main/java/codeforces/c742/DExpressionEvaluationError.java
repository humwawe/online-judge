package codeforces.c742;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DExpressionEvaluationError {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int s = in.nextInt();
    int n = in.nextInt();
    String ss = String.valueOf(s);
    int pw = (int) 1e9;
    while (n > 1) {
      while (s - pw < n - 1) {
        pw /= 10;
      }
      s -= pw;
      n--;
      out.print(pw + " ");
    }
    out.println(s);
  }

}
