package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CQueue {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    List<P> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new P(in.nextString(), in.nextInt()));
    }
    list.sort(Comparator.comparingInt(x -> x.cnt));
    int start = 3005;
    List<String> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      P p = list.get(i);
      if (p.cnt > i) {
        out.println(-1);
        return;
      }
      res.add(p.cnt, p.name);
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(res.get(i), start--);
    }
    for (P p : list) {
      out.println(p.name, map.get(p.name));
    }
  }

  class P {
    String name;
    int cnt;

    public P(String name, int cnt) {
      this.name = name;
      this.cnt = cnt;
    }
  }
}
