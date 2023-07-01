package atcoder.abc308;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class BDefaultPrice {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String[] a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextString();
    }
    String[] d = new String[m];

    for (int i = 0; i < m; i++) {
      d[i] = in.nextString();
    }
    int[] p = new int[m + 1];
    for (int i = 0; i < m + 1; i++) {
      p[i] = in.nextInt();
    }

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      map.put(d[i], p[i + 1]);
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      res += map.getOrDefault(a[i], p[0]);
    }
    out.println(res);
  }
}
