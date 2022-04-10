package acwing.contest.weekly.c46;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<String, Integer> cnt = new HashMap<>();
    Map<String, String> pos = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String str = in.nextString();
      Set<String> hs = new HashSet<>();
      for (int j = 0; j < str.length(); j++) {
        for (int k = j + 1; k <= str.length(); k++) {
          hs.add(str.substring(j, k));
        }
      }
      for (String v : hs) {
        cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        pos.put(v, str);
      }
    }
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      String x = in.nextString();
      int t = cnt.getOrDefault(x, 0);
      if (t == 0) {
        out.println("0 -");
      } else {
        out.println(t + " " + pos.get(x));
      }
    }

  }
}
