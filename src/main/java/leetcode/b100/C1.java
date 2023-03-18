package leetcode.b100;

/**
 * @author hum
 */
public class C1 {
  public int distMoney(int money, int children) {

    for (int i = children; i > -1; i--) {
      int need = i * 8;
      int x = children - i;
      if (need + x > money) {
        continue;
      }
      if (i == children - 1 && money - need == 4) {
        continue;
      }
      if (i == children && money != need) {
        continue;
      }
      return i;
    }
    return -1;
  }
}
