package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskH {
  long[] fact;
  int[] cnt;
  long ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    cnt = new int[10];
    long t = n;
    while (t > 0) {
      cnt[(int) (t % 10)]++;
      t /= 10;
    }
    fact = new long[20];
    fact[0] = 1;
    for (int i = 1; i <= 19; i++) {
      fact[i] = fact[i - 1] * i;
    }
    int[] cur = new int[10];
    for (int i = 0; i < 10; i++) {
      if (cnt[i] > 0) {
        cur[i] = 1;
      }
    }
    dfs(0, cur);
    out.println(ans);
  }

  private void dfs(int s, int[] cur) {
    ans += helper(cur);
    for (int i = s; i < 10; i++) {
      if (cur[i] < cnt[i]) {
        cur[i] += 1;
        dfs(i, cur);
        cur[i] -= 1;
      }
    }

  }

  private long helper(int[] cur) {
    int t1 = 0;
    long t2 = 1;
    long t3 = 1;
    for (int i = 0; i < 10; i++) {
      if (cur[i] > 0) {
        t1 += cur[i];
        t2 *= fact[cur[i]];
        if (i == 0) {
          t3 *= fact[cur[i] - 1];
        } else {
          t3 *= fact[cur[i]];
        }
      }
    }
    if (cur[0] > 0) {
      return fact[t1] / t2 - fact[t1 - 1] / t3;
    } else {
      return fact[t1] / t2;
    }

  }
}
