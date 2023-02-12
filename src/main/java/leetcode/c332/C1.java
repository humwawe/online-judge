package leetcode.c332;

/**
 * @author hum
 */
public class C1 {
  public long findTheArrayConcVal(int[] nums) {
    int n = nums.length;
    long res = 0;
    for (int i = 0; i < n / 2; i++) {
      int x = nums[i];
      int y = nums[n - 1 - i];
      res += Integer.parseInt(String.valueOf(x) + String.valueOf(y));
    }
    if (n % 2 != 0) {
      res += nums[n / 2];
    }
    return res;
  }
}
