package leetcode.c327;

/**
 * @author hum
 */
public class C1 {
  public int maximumCount(int[] nums) {
    int x = 0;
    int y = 0;
    for (int num : nums) {
      if (num > 0) {
        x++;
      } else if (num < 0) {
        y++;
      }
    }
    return Math.max(x, y);
  }
}
