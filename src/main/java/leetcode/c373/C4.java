package leetcode.c373;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C4 {
  public long beautifulSubstrings(String s, int k) {
    int n = s.length();
    int len = 0;
    for (int i = 1; i <= k; i++) {
      if (i * i % k == 0) {
        len = i;
        break;
      }
    }
    len *= 2;
    long res = 0;
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + (isV(s.charAt(i)) ? 1 : -1);
    }

    Map<String, Integer> map = new HashMap<>();

    map.put("0-0", 1);
    for (int i = 0; i < n; i++) {
      String key = sum[i + 1] + "-" + (i + 1) % len;
      res += map.getOrDefault(key, 0);
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    return res;
  }


  private boolean isV(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
