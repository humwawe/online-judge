package leetcode.b111;

/**
 * @author hum
 */
public class C2 {
  public boolean canMakeSubsequence(String str1, String str2) {
    int n = str1.length();
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (j == str2.length()) {
        return true;
      }
      if (str1.charAt(i) == str2.charAt(j) || helper(str1.charAt(i)) == str2.charAt(j)) {
        j++;
      }
    }
    return j == str2.length();
  }

  private char helper(char c) {
    return (char) ('a' + (c - 'a' + 1) % 26);
  }
}
