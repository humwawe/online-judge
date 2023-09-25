package leetcode.c364;

/**
 * @author hum
 */
public class C1 {
  public String maximumOddBinaryNumber(String s) {
    int n = s.length();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        cnt++;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append("1".repeat(cnt - 1));
    sb.append("0".repeat(n - cnt));
    sb.append(1);
    return sb.toString();
  }
}
