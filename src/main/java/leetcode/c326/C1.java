package leetcode.c326;

/**
 * @author hum
 */
public class C1 {
  public int countDigits(int num) {
    int t = num;
    int res = 0;
    while (t > 0) {
      int x = t % 10;
      if (num % x == 0) {
        res++;
      }
      t /= 10;
    }
    return res;
  }
}
