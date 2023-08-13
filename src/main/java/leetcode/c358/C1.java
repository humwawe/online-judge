package leetcode.c358;

/**
 * @author hum
 */
public class C1 {
  public int maxSum(int[] nums) {
    int n = nums.length;
    int res = -1;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (check(String.valueOf(nums[i]), String.valueOf(nums[j]))) {
          res = Math.max(res, nums[i] + nums[j]);
        }
      }
    }
    return res;
  }

  private boolean check(String s1, String s2) {
    int n1 = 0;
    for (int i = 0; i < s1.length(); i++) {
      n1 = Math.max(n1, s1.charAt(i) - '0');
    }
    int n2 = 0;
    for (int i = 0; i < s2.length(); i++) {
      n2 = Math.max(n2, s2.charAt(i) - '0');
    }
    return n1 == n2;
  }
}
