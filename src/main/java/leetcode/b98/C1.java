package leetcode.b98;

/**
 * @author hum
 */
public class C1 {
  public int minMaxDifference(int num) {
    String s = String.valueOf(num);
    int max = num;
    for (int i = 0; i < 9; i++) {
      max = Math.max(max, helper(s, i, 9));
    }
    int min = num;
    for (int i = 1; i <= 9; i++) {
      min = Math.min(min, helper(s, i, 0));
    }
    return max - min;
  }

  private int helper(String s, int a, int b) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c - '0' == a) {
        stringBuilder.append(b);
      } else {
        stringBuilder.append(c);
      }
    }
    return Integer.parseInt(stringBuilder.toString());
  }
}
