package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CEugeneAndAnArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    long res = 0;

    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 0);

    long sum = 0;
    int max = -1;
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
      max = Math.max(max, map.getOrDefault(sum, -1));
      res += i - max - 1;

      map.put(sum, i);

    }
    out.println(res);

  }
}
