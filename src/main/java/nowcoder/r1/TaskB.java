package nowcoder.r1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    int[] a = in.nextInt(n);
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      char c = in.nextCharacter();
      if (c == 'B') {
        b[i] = 1;
      }
    }

    for (int i = 0; i < n; i++) {
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
      if (b[i] == 1) {
        map2.put(a[i], map2.getOrDefault(a[i], 0) + 1);
      }
    }
    long res = 0;
    for (Integer k : map.keySet()) {
      int size = map.get(k);
      int blue = map2.getOrDefault(k, 0);
      res += (long) (size - blue) * blue;
    }
    out.println(res);

  }
}
