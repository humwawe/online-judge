package acwing.contest.weekly.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    String s = String.valueOf(n);
    if (s.length() % 2 == 1) {
      int cnt = (s.length() + 1) / 2;
      out.println("4".repeat(cnt) + "7".repeat(cnt));
      return;
    }
    int cnt = s.length() / 2;
    long x = Long.parseLong("7".repeat(cnt) + "4".repeat(cnt));
    if (x < n) {
      out.println("4".repeat(cnt + 1) + "7".repeat(cnt + 1));
      return;
    }

    dfs(cnt, cnt, "");
    out.println(ans);
  }

  String ans = "";

  private boolean dfs(int a, int b, String v) {
    if (a == 0 && b == 0) {
      if (Long.parseLong(v) >= n) {
        ans = v;
        return true;
      }
    }
    if (a > 0) {
      if (dfs(a - 1, b, v + "4")) {
        return true;
      }
    }
    if (b > 0) {
      if (dfs(a, b - 1, v + "7")) {
        return true;
      }
    }
    return false;
  }
}
