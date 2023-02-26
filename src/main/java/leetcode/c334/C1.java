package leetcode.c334;

/**
 * @author hum
 */
public class C1 {
  public int[] leftRigthDifference(int[] nums) {
    int n = nums.length;
    int[] l = new int[n];
    for (int i = 1; i < n; i++) {
      l[i] = l[i - 1] + nums[i - 1];
    }
    int[] r = new int[n];
    for (int i = n - 2; i >= 0; i--) {
      r[i] = r[i + 1] + nums[i + 1];
    }
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = Math.abs(l[i] - r[i]);
    }
    return res;
  }
}
