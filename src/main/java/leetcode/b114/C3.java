package leetcode.b114;

/**
 * @author hum
 */
public class C3 {

  public int maxSubarrays(int[] nums) {
    int x = nums[0];
    for (int num : nums) {
      x &= num;
    }
    if (x != 0) {
      return 1;
    }
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; ) {
      int cur = nums[i];
      int j = i;
      while (j + 1 < n && cur != x) {
        cur &= nums[j + 1];
        j++;
      }
      if (cur == x) {
        res++;
      }
      i = j + 1;
    }
    return res;
  }
}
