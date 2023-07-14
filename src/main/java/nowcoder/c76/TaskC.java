package nowcoder.c76;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int b = n - m;
    int a = m;
    if (b >= 0 && b > m) {
      out.println(a, b);
    } else {
      out.println(-1);
    }
  }
}
