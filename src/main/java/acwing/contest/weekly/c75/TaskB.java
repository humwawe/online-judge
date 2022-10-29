package acwing.contest.weekly.c75;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    List<P> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    map.put("rat", 1);
    map.put("woman", 2);
    map.put("child", 2);
    map.put("man", 3);
    map.put("captain", 4);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      String s = in.nextString();
      String t = in.nextString();
      list.add(new P(i, map.get(t), s));
    }
    list.sort((x, y) -> {
      int d = x.t - y.t;
      if (d == 0) {
        return x.i - y.i;
      }
      return d;
    });
    for (P p : list) {
      out.println(p.name);
    }
  }

  class P {
    int i;
    int t;
    String name;

    public P(int i, int t, String name) {
      this.i = i;
      this.t = t;
      this.name = name;
    }
  }
}
