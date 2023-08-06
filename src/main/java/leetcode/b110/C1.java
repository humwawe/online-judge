package leetcode.b110;

/**
 * @author hum
 */
public class C1 {
  public int accountBalanceAfterPurchase(int purchaseAmount) {
    int x = purchaseAmount / 10 * 10;
    int y = x + 10;
    if (y - purchaseAmount == purchaseAmount - x) {
      return 100 - y;
    } else if (y - purchaseAmount < purchaseAmount - x) {
      return 100 - y;
    } else {
      return 100 - x;
    }
  }
}
