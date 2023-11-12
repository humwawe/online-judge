package leetcode.b117;

/**
 * @author hum
 */
public class C2 {
  public long distributeCandies(int n, int limit) {
    long res = 0;
    for (int i = 0; i <= limit; i++) {
      long last = n - i;
      res += Math.max(0, Math.min(last, limit) - Math.max(0, last - limit) + 1);
    }
    return res;
  }
}
