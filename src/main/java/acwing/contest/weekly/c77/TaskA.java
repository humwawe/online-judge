package acwing.contest.weekly.c77;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String x = in.nextString();
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    int max = 0;
    String res = "";

    for (String s : map.keySet()) {
      if (map.get(s) > max) {
        res = s;
        max = map.get(s);
      }
    }
    out.println(res);
  }
}
