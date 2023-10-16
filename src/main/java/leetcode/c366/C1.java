package leetcode.c366;

/**
 * @author hum
 */
public class C1 {
  public int differenceOfSums(int n, int m) {
    int res = 0;
    for (int i = 1; i <= n; i++) {
      if (i % m == 0) {
        res -= i;
      } else {
        res += i;
      }
    }
    return res;
  }
}
