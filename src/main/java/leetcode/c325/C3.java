package leetcode.c325;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {
  public int maximumTastiness(int[] price, int k) {
    int n = price.length;
    Arrays.sort(price);
    int l = 0;
    int r = price[n - 1] - price[0];
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid, price, k)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }

  private boolean check(int mid, int[] price, int k) {
    int n = price.length;
    int cnt = 1;
    int last = 0;
    for (int i = 1; i < n; i++) {
      if (price[i] - price[last] >= mid) {
        cnt++;
        last = i;
      }
    }
    return cnt >= k;
  }
}
