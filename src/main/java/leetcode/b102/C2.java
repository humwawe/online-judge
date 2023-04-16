package leetcode.b102;

/**
 * @author hum
 */
public class C2 {
  public long[] findPrefixScore(int[] nums) {
    int n = nums.length;
    int[] a = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, nums[i]);
      a[i] = nums[i] + max;
    }
    long[] res = new long[n];
    res[0] = a[0];
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] + a[i];
    }
    return res;
  }
}
