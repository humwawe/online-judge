package leetcode.b107;

/**
 * @author hum
 */
public class C2 {
  public int longestString(int x, int y, int z) {
    int res = z;
    int t = Math.min(x, y);
    res += t * 2;
    x -= t;
    y -= t;
    if (x > 0 || y > 0) {
      res++;
    }
    return res * 2;
  }
}
