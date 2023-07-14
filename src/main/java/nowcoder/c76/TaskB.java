package nowcoder.c76;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 1) {
      out.println(0);
      return;
    }
    n--;
    String s = Integer.toString(n, 2);
    out.println(s.length());
  }
}
