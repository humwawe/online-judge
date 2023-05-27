package leetcode.b105;

import java.util.Arrays;

/**
 * @author hum
 */
public class C1 {
  public int buyChoco(int[] prices, int money) {
    Arrays.sort(prices);
    if (money - prices[0] - prices[1] < 0) {
      return money;
    }
    return money - prices[0] - prices[1];
  }
}
