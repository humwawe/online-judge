package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CBerryJam {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    for (int i = 0; i < n; i++) {
      if (a[i] == 1) {
        sum++;
      } else {
        sum--;
      }
      map.put(sum, i + 1);
    }
    sum = 0;
    Map<Integer, Integer> map2 = new HashMap<>();
    map2.put(0, n);
    for (int i = n - 1; i >= 0; i--) {
      if (b[i] == 1) {
        sum--;
      } else {
        sum++;
      }
      map2.put(sum, i);
    }
    int res = 2 * n;

    for (Integer i : map.keySet()) {
      int x = map.get(i);
      int y = map2.getOrDefault(i, -1);
      if (y == -1) {
        continue;
      }
      res = Math.min(res, n - x + y);
    }
    out.println(res);
  }
}
