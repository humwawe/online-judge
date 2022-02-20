package acwing.contest.weekly.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskB {

  List<Long> list = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long l = in.nextLong();
    long r = in.nextLong();
    dfs(10, 0);
    Collections.sort(list);
    long res = 0;
    for (int i = 0; i < list.size(); i++) {
      long t = list.get(i);
      if (t >= l && r >= t) {
        res += t * (t - l + 1);
        l = t + 1;
      } else if (l <= t) {
        res += t * (r - l + 1);
        break;
      }
    }
    out.println(res);

  }

  private void dfs(int len, long num) {
    if (len == 0) {
      return;
    }
    long tmp1 = num * 10 + 4;
    list.add(tmp1);
    dfs(len - 1, tmp1);
    long tmp2 = num * 10 + 7;
    list.add(tmp2);
    dfs(len - 1, tmp2);
  }
}
