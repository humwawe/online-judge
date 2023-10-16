package leetcode.c367;

/**
 * @author hum
 */
public class C1 {
  public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
    int n = nums.length;
    int[] res = {-1, -1};

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
          res[0] = i;
          res[1] = j;
          return res;
        }
      }
    }
    return res;
  }
}
