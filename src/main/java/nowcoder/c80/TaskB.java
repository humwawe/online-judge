package nowcoder.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int max = 0;
    int[] cnt = new int[m];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt() - 1;
      max = Math.max(max, ++cnt[x]);
    }

    if (k <= n - max) {
      out.println(max);
    } else {
      out.println(max - (k - (n - max)));
    }
  }
}
