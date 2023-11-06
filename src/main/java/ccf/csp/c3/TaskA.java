package ccf.csp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] cnt = new int[1005];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      cnt[x]++;
      out.print(cnt[x], "");
    }
    out.println();
  }
}
