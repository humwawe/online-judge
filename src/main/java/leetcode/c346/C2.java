package leetcode.c346;

/**
 * @author hum
 */
public class C2 {
  public String makeSmallestPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    char[] a = s.toCharArray();
    while (i < j) {
      if (a[i] != a[j]) {
        char c;
        if (a[i] > a[j]) {
          c = a[j];
        } else {
          c = a[i];
        }
        a[i] = a[j] = c;
      }
      i++;
      j--;
    }
    return new String(a);
  }
}
