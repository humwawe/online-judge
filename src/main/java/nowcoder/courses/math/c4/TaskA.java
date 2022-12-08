package nowcoder.courses.math.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  int[] cur = new int[]{2, 5, 11, 13};

  long n;
  long ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextLong();
    ans = 0;
    dfs(0, 1, 1);
    out.println(ans);
    //    for (int i = 1; i < (1 << 4); i++) {
    //      long tmp = 1;
    //      int cnt = 0;
    //      for (int j = 0; j < 4; j++) {
    //        if ((i >> j & 1) == 1) {
    //          tmp *= cur[j];
    //          cnt++;
    //        }
    //      }
    //      int t = 1;
    //      if (cnt % 2 == 0) {
    //        t = -1;
    //      }
    //      ans += n / tmp * t;
    //    }
    //    out.println(n - ans);
  }

  private void dfs(int p, long sum, int f) {
    if (p == cur.length) {
      ans += n / sum * f;
      return;
    }
    dfs(p + 1, sum, f);
    dfs(p + 1, sum * cur[p], -f);
  }
}
