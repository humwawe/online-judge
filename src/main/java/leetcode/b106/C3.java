package leetcode.b106;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {
  public int sumDistance(int[] nums, String s, int d) {
    int n = nums.length;
    long[] tmp = new long[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      tmp[i] = s.charAt(i) == 'R' ? (long) nums[i] + d : (long) nums[i] - d;
      sum += tmp[i];
    }
    Arrays.sort(tmp);

    int mod = (int) (1e9 + 7);
    long res = 0;

    for (int i = 0; i < n; i++) {
      sum -= tmp[i];
      res += sum - tmp[i] * (n - 1 - i);
      res %= mod;
    }
    return (int) res;
  }
}
