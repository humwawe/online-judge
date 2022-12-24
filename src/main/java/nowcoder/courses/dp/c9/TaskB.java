package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long base = (long) (1e5 + 5);
    Map<Long, Integer> cnt = new HashMap<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int a = in.nextInt() + 1;
      int b = n - in.nextInt();
      if (a > b) {
        continue;
      }
      long x = a * base + b;
      cnt.put(x, cnt.getOrDefault(x, 0) + 1);
      map.computeIfAbsent(b, e -> new HashSet<>()).add(a);
    }

    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1];
      Set<Integer> set = map.get(i);
      if (set == null) {
        continue;
      }

      for (Integer j : set) {
        long x = j * base + i;
        dp[i] = Math.max(dp[i], dp[j - 1] + Math.min(cnt.get(x), i - j + 1));
      }
    }

    out.println(n - dp[n]);

  }
}
