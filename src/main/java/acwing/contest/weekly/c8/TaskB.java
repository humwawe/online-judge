package acwing.contest.weekly.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Integer, Long> map = new HashMap<>();
    long res = 0;
    for (int i = 0; i < n; i++) {
      int t = in.nextInt() - i;
      map.put(t, map.getOrDefault(t, 0L) + t + i);
      res = Math.max(res, map.get(t));
    }
    out.println(res);
  }
}
