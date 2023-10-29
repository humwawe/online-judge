package leetcode.c369;

/**
 * @author hum
 */
public class C3 {

  long inf = (long) 1e15;
  int[] nums;
  int k;
  Long[][] memo;
  int n;

  public long minIncrementOperations(int[] nums, int k) {
    n = nums.length;
    this.nums = nums;
    this.k = k;
    memo = new Long[n][3];
    return dfs(0, 0);

  }

  private long dfs(int i, int j) {
    if (j > 2) {
      return inf;
    }
    if (i == n) {
      return 0;
    }
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    long res = inf;
    res = Math.min(res, dfs(i + 1, 0) + Math.max(0, k - nums[i]));
    res = Math.min(res, dfs(i + 1, j + 1));
    return memo[i][j] = res;
  }


}
