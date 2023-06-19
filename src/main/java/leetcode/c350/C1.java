package leetcode.c350;

/**
 * @author hum
 */
public class C1 {
  public int distanceTraveled(int mainTank, int additionalTank) {
    int res = 0;
    int cnt = 0;
    while (mainTank > 0) {
      mainTank--;
      res += 10;
      cnt++;
      if (cnt == 5 && additionalTank > 0) {
        cnt = 0;
        mainTank++;
        additionalTank--;
      }
    }
    return res;
  }
}
