package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class FEquateMultisets {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      while (x % 2 == 0) {
        x /= 2;
      }
      a[i] = x;
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      while (x % 2 == 0) {
        x /= 2;
      }
      b[i] = x;
    }
    for (int i = 0; i < n; i++) {
      int x = b[i];
      while (!map.containsKey(x) && x != 0) {
        x /= 2;
      }
      if (x == 0) {
        out.println("NO");
        return;
      }
      map.put(x, map.get(x) - 1);
      if (map.get(x) == 0) {
        map.remove(x);
      }
    }
    out.println("YES");
  }
}
