package leetcode.b99;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {
  public int splitNum(int num) {
    char[] chars = String.valueOf(num).toCharArray();
    Arrays.sort(chars);
    int a = 0;
    int b = 0;

    for (int i = 0; i < chars.length; i += 2) {
      a = a * 10 + (chars[i] - '0');
      if (i + 1 < chars.length) {
        b = b * 10 + (chars[i + 1] - '0');
      }
    }

    return a + b;

  }
}
