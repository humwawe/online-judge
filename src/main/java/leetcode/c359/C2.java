package leetcode.c359;

/**
 * @author hum
 */
public class C2 {
  public int minimumSum(int n, int k) {
    int res = 0;
    int cnt = 0;
    for (int i = 1; i <= Math.min(n, k / 2); i++) {
      res += i;
      cnt++;
    }

    for (int i = 0; i < n - cnt; i++) {
      res += k + i;
    }
    return res;
  }
}
