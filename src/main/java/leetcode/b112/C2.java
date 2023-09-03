package leetcode.b112;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public boolean checkStrings(String s1, String s2) {
    int n = s1.length();
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    StringBuilder sb3 = new StringBuilder();
    StringBuilder sb4 = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        sb1.append(s1.charAt(i));
        sb3.append(s2.charAt(i));
      } else {
        sb2.append(s1.charAt(i));
        sb4.append(s2.charAt(i));
      }
    }
    char[] c1 = sb1.toString().toCharArray();
    char[] c2 = sb2.toString().toCharArray();
    char[] c3 = sb3.toString().toCharArray();
    char[] c4 = sb4.toString().toCharArray();

    Arrays.sort(c1);
    Arrays.sort(c2);
    Arrays.sort(c3);
    Arrays.sort(c4);

    return new String(c1).equals(new String(c3)) && new String(c2).equals(new String(c4));

  }
}
