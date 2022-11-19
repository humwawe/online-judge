package atcoder.abc278;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CFF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();
      if (t == 1) {
        map.computeIfAbsent(b, e -> new HashSet<>()).add(a);
      } else if (t == 2) {
        map.computeIfAbsent(b, e -> new HashSet<>()).remove(a);
      } else {
        Set<Integer> set1 = map.getOrDefault(a, null);
        Set<Integer> set2 = map.getOrDefault(b, null);
        if (set1 != null && set2 != null && set1.contains(b) && set2.contains(a)) {
          out.println("Yes");
        } else {
          out.println("No");
        }
      }

    }

  }
}
