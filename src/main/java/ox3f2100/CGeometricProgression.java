package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CGeometricProgression {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Map<Long, Long> map0 = new HashMap<>();
    Map<Long, Long> map1 = new HashMap<>();
    int n = in.nextInt();
    int k = in.nextInt();
    long res = 0;
    for (int i = 0; i < n; i++) {
      long x = in.nextInt();
      if (x % k == 0) {
        res += map1.getOrDefault(x / k, 0L);
        map1.put(x, map1.getOrDefault(x, 0L) + map0.getOrDefault(x / k, 0L));
      }
      map0.put(x, map0.getOrDefault(x, 0L) + 1);
    }
    out.println(res);
  }
}
