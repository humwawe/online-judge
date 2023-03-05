package leetcode.c335;

/**
 * @author hum
 */
public class C1 {
  public int passThePillow(int n, int time) {
    int cur = 1;
    int f = 1;
    for (int i = 1; i <= time; i++) {
      cur += f;
      if (cur > n) {
        f = -1;
        cur -= 2;
      } else if (cur <= 0) {
        f = 1;
        cur += 2;
      }
    }
    return cur;
  }
}
