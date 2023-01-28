package leetcode.b96;

/**
 * @author hum
 */
public class C4 {
  public boolean isReachable(int targetX, int targetY) {
    while (targetX % 2 == 0) {
      targetX /= 2;
    }
    while (targetY % 2 == 0) {
      targetY /= 2;
    }
    return gcd(targetX, targetY) == 1;
  }

  public int gcd(int a, int b) {
    while (b > 0) {
      int c = a;
      a = b;
      b = c % b;
    }
    return a;
  }
}
