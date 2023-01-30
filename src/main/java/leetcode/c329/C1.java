package leetcode.c329;

/**
 * @author hum
 */
public class C1 {
  public int alternateDigitSum(int n) {
    String s = String.valueOf(n);
    int sign = 1;
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      res += sign * (s.charAt(i) - '0');
      sign *= -1;
    }
    return res;
  }
}
