package leetcode.c352;

/**
 * @author hum
 */
public class C1 {

  public int longestAlternatingSubarray(int[] nums, int threshold) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] % 2 == 0 && nums[i] <= threshold) {
        int j = i;
        while (j + 1 < n && nums[j + 1] % 2 != nums[j] % 2 && nums[j + 1] <= threshold) {
          j++;
        }
        res = Math.max(res, j - i + 1);
      }
    }
    return res;
  }
}
