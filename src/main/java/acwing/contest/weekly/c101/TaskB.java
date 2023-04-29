package acwing.contest.weekly.c101;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<String, Integer> map = new HashMap<>();
    int idx = 0;
    for (int i = 0; i < n; i++) {
      String s = in.nextString();
      map.put(s, idx++);
    }
    Set<String> set = map.keySet();
    List<String> list = new ArrayList<>(set);
    list.sort((x, y) -> map.get(y) - map.get(x));

    for (String s : list) {
      out.println(s);
    }
  }
}
