package leetcode.c361;

/**
 * @author hum
 */
public class C1 {
  public int countSymmetricIntegers(int low, int high) {
    int res = 0;
    for (int i = low; i <= high; i++) {
      String s = String.valueOf(i);
      int n = s.length();
      if (n % 2 != 0) {
        continue;
      }
      int t = 0;
      for (int j = 0; j < n; j++) {
        if (j < n / 2) {
          t += s.charAt(j) - '0';
        } else {
          t -= s.charAt(j) - '0';
        }
      }
      if (t == 0) {
        res++;
      }
    }
    return res;
  }
}
