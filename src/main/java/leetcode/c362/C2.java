package leetcode.c362;

/**
 * @author hum
 */
public class C2 {
  public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    if (sx == fx && sy == fy && t == 1) {
      return true;
    }
    int x = Math.abs(sx - fx);
    int y = Math.abs(sy - fy);
    return Math.max(x, y) <= t;
  }
}
