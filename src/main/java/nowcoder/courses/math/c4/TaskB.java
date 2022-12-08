package nowcoder.courses.math.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int[] cur;
  long ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long l = in.nextLong();
    long r = in.nextLong();
    int k = in.nextInt();
    cur = in.nextInt(k);
    ans = 0;
    dfs(r, 0, 1, -1);
    long res = r - ans;
    ans = 0;
    dfs(l - 1, 0, 1, -1);
    out.println(res - (l - 1 - ans));
  }

  private void dfs(long n, int p, long sum, int f) {
    if (sum > n) {
      return;
    }
    if (p == cur.length) {
      if (sum > 1) {
        ans += n / sum * f;
      }
      return;
    }
    dfs(n, p + 1, sum, f);
    dfs(n, p + 1, sum * cur[p], -f);
  }
}
