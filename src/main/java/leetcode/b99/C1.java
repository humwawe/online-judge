package leetcode.b99;

/**
 * @author hum
 */
public class C1 {
  public long coloredCells(int n) {
    long res = 1;
    for (int i = 1; i <= n; i++) {
      res += 4 * (i - 1);
    }
    return res;
  }
}
