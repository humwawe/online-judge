package leetcode.c360;

/**
 * @author hum
 */
public class C2 {
  public long minimumPossibleSum(int n, int target) {
    long res = 0;
    int cnt = 0;
    for (int i = 1; i <= Math.min(n, target / 2); i++) {
      res += i;
      cnt++;
    }

    for (int i = 0; i < n - cnt; i++) {
      res += target + i;
    }
    return res;
  }
}
