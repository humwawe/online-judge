package leetcode.c335;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  public int findValidSplit(int[] nums) {
    int N = (int) 1e6 + 5;
    int[] lpf = sieveLowestPrime(N);
    int n = nums.length;
    Map<Integer, Integer> min = new HashMap<>();
    Map<Integer, Integer> max = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int t = nums[i];
      while (t != 1) {
        int p = lpf[t];
        if (!min.containsKey(p)) {
          min.put(p, i);
        }
        max.put(p, i);
        t /= p;
      }
    }

    f:
    for (int i = 0; i < n - 1; i++) {
      for (Integer p : min.keySet()) {
        if (min.get(p) <= i && max.get(p) > i) {
          continue f;
        }

      }
      return i;
    }

    return -1;
  }

  public int[] sieveLowestPrime(int n) {
    int tot = 0;
    int[] lpf = new int[n + 1];
    int u = n + 32;
    double lu = Math.log(u);
    int[] primes = new int[(int) (u / lu + u / lu / lu * 1.5)];
    for (int i = 2; i <= n; i++) {
      lpf[i] = i;
    }
    for (int p = 2; p <= n; p++) {
      if (lpf[p] == p) {
        primes[tot++] = p;
      }
      int tmp;
      for (int i = 0; i < tot && primes[i] <= lpf[p] && (tmp = primes[i] * p) <= n; i++) {
        lpf[tmp] = primes[i];
      }
    }
    return lpf;
  }
}
