package leetcode.c344;

/**
 * @author hum
 */
public class C4 {
  int[] cost;
  int n;
  int ans;

  public int minIncrements(int n, int[] cost) {
    this.cost = cost;
    this.n = n;
    dfs(1, 0);

    return ans;
  }

  private int dfs(int i, int dep) {
    if (i > n) {
      return 0;
    }
    int left = dfs(i * 2, dep + 1);
    int right = dfs(i * 2 + 1, dep + 1);
    ans += Math.abs(right - left);
    return cost[i - 1] + Math.max(right, left);
  }
}
