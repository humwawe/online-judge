package leetcode.c367;

/**
 * @author hum
 */
public class C3 {
  public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
    int n = nums.length;
    int min = 0;
    int max = 0;
    int[] res = {-1, -1};

    for (int i = indexDifference; i < n; i++) {

      if (Math.abs(nums[i] - nums[min]) >= valueDifference) {
        res[0] = min;
        res[1] = i;
        return res;
      }
      if (Math.abs(nums[i] - nums[max]) >= valueDifference) {
        res[0] = max;
        res[1] = i;
        return res;
      }

      int t = i - indexDifference + 1;
      if (t < n) {
        if (nums[t] < nums[min]) {
          min = t;
        }
        if (nums[t] > nums[max]) {
          max = t;
        }
      }
    }
    return res;
  }
}
