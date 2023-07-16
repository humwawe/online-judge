package leetcode.c354;

/**
 * @author hum
 */
public class C2 {
  public int maximumBeauty(int[] nums, int k) {
    int base = (int) 1e5;
    int[] sum = new int[(int) 3e5 + 5];
    for (int num : nums) {
      sum[num - k + base] += 1;
      sum[num + k + 1 + base] -= 1;
    }
    int res = sum[0];
    for (int i = 1; i < sum.length; i++) {
      sum[i] += sum[i - 1];
      res = Math.max(res, sum[i]);
    }
    return res;
  }
}
