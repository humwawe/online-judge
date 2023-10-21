package lanqiao.b1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeSet;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int q = in.nextInt();
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < q; i++) {
      set.add(in.nextInt());
    }
    int[][] a = new int[m][2];
    for (int i = 0; i < m; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }

    set.add(0);

    long[] dp = new long[n + 1];

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1];
      Integer floor = set.floor(i);
      for (int j = 0; j < m; j++) {
        int len = 1 << a[j][0];
        if (i - floor < len) {
          continue;
        }
        dp[i] = Math.max(dp[i], dp[i - len] + a[j][1]);
      }
    }
    out.println(dp[n]);


  }
}
