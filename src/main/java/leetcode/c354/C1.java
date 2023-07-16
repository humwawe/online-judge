package leetcode.c354;

/**
 * @author hum
 */
public class C1 {
  public int sumOfSquares(int[] nums) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (n % (i + 1) == 0) {
        res += nums[i] * nums[i];
      }
    }
    return res;
  }
}
