package leetcode.c339;

/**
 * @author hum
 */
public class C1 {
  public int findTheLongestBalancedSubstring(String s) {
    int n = s.length();
    int res = 0;
    for (int i = 1; i <= n / 2; i++) {
      String t = "0".repeat(i) + "1".repeat(i);
      if (s.contains(t)) {
        res = Math.max(res, i * 2);
      }
    }
    return res;
  }
}
