package leetcode.c347;

/**
 * @author hum
 */
public class C1 {
  public String removeTrailingZeros(String num) {
    int n = num.length();
    int i = n - 1;
    for (; i >= 0; i--) {
      if (num.charAt(i) == '0') {
      } else {
        break;
      }
    }
    return num.substring(0, i + 1);
  }
}
