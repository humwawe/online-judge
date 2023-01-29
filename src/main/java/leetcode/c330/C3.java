package leetcode.c330;

/**
 * @author PF-2CRL0N
 */
public class C3 {
  public long countQuadruplets(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      nums[i]--;
    }
    int[][] pre = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i - 1 >= 0) {
          pre[i][j] = pre[i - 1][j];
        }
      }
      for (int j = nums[i] + 1; j < n; j++) {
        pre[i][j]++;
      }
    }

    int[][] suf = new int[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        if (i + 1 < n) {
          suf[i][j] = suf[i + 1][j];
        }
      }
      for (int j = 0; j < nums[i]; j++) {
        suf[i][j]++;
      }
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[j] < nums[i]) {
          res += pre[i][nums[j]] * suf[j][nums[i]];
        }
      }
    }
    return res;
  }
}
