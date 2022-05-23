package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class FConsecutiveSubsequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    int cur = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      a[i] = x;
      map.put(x, map.getOrDefault(x - 1, 0) + 1);
      if (map.get(x) > res) {
        res = map.get(x);
        cur = x;
      }
    }
    int s = cur - res + 1;
    out.println(res);
    for (int i = 0; i < n; i++) {
      if (a[i] == s) {
        out.print(i + 1, "");
        s++;
      }
    }

  }
}
