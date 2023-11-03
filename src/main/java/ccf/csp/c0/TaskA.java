package ccf.csp.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] cnt = new int[10005];
    for (int i : a) {
      cnt[i]++;
    }
    int cur = 0;
    for (int i = 1; i < 10005; i++) {
      if (cnt[i] > cnt[cur]) {
        cur = i;
      }
    }
    out.println(cur);
  }
}
