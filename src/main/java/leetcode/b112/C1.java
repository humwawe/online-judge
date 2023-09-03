package leetcode.b112;

/**
 * @author hum
 */
public class C1 {
  public boolean canBeEqual(String s1, String s2) {
    return helper(s1).equals(helper(s2));
  }

  private String helper(String s1) {
    char[] ss1 = s1.toCharArray();
    if (ss1[0] > ss1[2]) {
      char c = ss1[0];
      ss1[0] = ss1[2];
      ss1[2] = c;
    }

    if (ss1[1] > ss1[3]) {
      char c = ss1[1];
      ss1[1] = ss1[3];
      ss1[3] = c;
    }
    return new String(ss1);
  }
}
