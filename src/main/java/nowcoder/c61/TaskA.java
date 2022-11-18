package nowcoder.c61;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long v = in.nextInt();
    long sum = 0;
    int res = 1;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (sum + x > v) {
        sum = 0;
        res++;
      }
      sum += x;
    }
    out.println(res);
  }
}
