package leetcode.b115;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C4 {
  public int countSubMultisets(List<Integer> nums, int l, int r) {
    int mod = (int) (1e9 + 7);
    int total = 0;
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int x : nums) {
      total += x;
      cnt.merge(x, 1, Integer::sum);
    }
    if (l > total) {
      return 0;
    }

    r = Math.min(r, total);
    int[] f = new int[r + 1];
    f[0] = cnt.getOrDefault(0, 0) + 1;
    cnt.remove(0);

    int sum = 0;
    for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
      int x = e.getKey(), c = e.getValue();
      sum = Math.min(sum + x * c, r);
      for (int j = x; j <= sum; j++) {
        f[j] = (f[j] + f[j - x]) % mod;
      }
      for (int j = sum; j >= x * (c + 1); j--) {
        f[j] = (f[j] - f[j - x * (c + 1)] + mod) % mod;
      }
    }

    int res = 0;
    for (int i = l; i <= r; ++i) {
      res = (res + f[i]) % mod;
    }
    return res;
  }

}
