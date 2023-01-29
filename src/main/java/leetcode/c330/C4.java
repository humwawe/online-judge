package leetcode.c330;

import java.util.Arrays;

/**
 * @author PF-2CRL0N
 */
public class C4 {
  public long putMarbles(int[] weights, int k) {
    int n = weights.length;
    int[] sum = new int[n - 1];

    for (int i = 0; i < n - 1; i++) {
      sum[i] = weights[i] + weights[i + 1];
    }
    Arrays.sort(sum);

    long res = 0;

    for (int i = 0; i < k - 1; i++) {
      res -= sum[i];
    }

    for (int i = n - 1 - k; i < n - 1; i++) {
      res += sum[i];
    }

    return res;
  }
}
