package leetcode.b117;

/**
 * @author hum
 */
public class C3 {


  int mod = (int) (1e9 + 7);
  int n;
  Long[][][][] memo;

  public int stringCount(int n) {
    this.n = n;
    memo = new Long[n][2][3][2];
    return (int) dfs(0, 0, 0, 0) % mod;
  }


  private long dfs(int i, int l, int e, int t) {

    if (i == n) {
      if (l >= 1 && e >= 2 && t >= 1) {
        return 1;
      }
      return 0;
    }
    if (memo[i][l][e][t] != null) {
      return memo[i][l][e][t];
    }
    long res = 0;
    res = (res + 23 * dfs(i + 1, l, e, t)) % mod;
    res = (res + dfs(i + 1, Math.min(1, l + 1), e, t)) % mod;
    res = (res + dfs(i + 1, l, Math.min(2, e + 1), t)) % mod;
    res = (res + dfs(i + 1, l, e, Math.min(1, t + 1))) % mod;
    return memo[i][l][e][t] = res;
  }
}
