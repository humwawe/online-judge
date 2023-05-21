package leetcode.c346;

/**
 * @author hum
 */
public class C3 {
  public int punishmentNumber(int n) {
    int res = 0;
    for (int i = 1; i <= n; i++) {
      int x = i * i;
      if (check(i, String.valueOf(x))) {
        res += x;
      }
    }
    return res;
  }

  private boolean check(int v, String s) {
    return dfs(v, 0, s, 0);
  }

  private boolean dfs(int v, int i, String s, int sum) {
    if (sum > v) {
      return false;
    }
    if (i == s.length()) {
      return sum == v;
    }

    for (int j = i; j < s.length(); j++) {
      if (dfs(v, j + 1, s, sum + Integer.parseInt(s.substring(i, j + 1)))) {
        return true;
      }
    }
    return false;
  }
}
