package leetcode.c332;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {


  public int minimumScore(String s, String t) {
    int n = s.length();
    int m = t.length();
    int[] suf = new int[n + 1];
    int inf = (int) 1e6;
    Arrays.fill(suf, inf);
    int j = m - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (j >= 0 && s.charAt(i) == t.charAt(j)) {
        suf[i] = j;
        j--;
      }
      suf[i] = Math.min(suf[i], suf[i + 1]);
    }

    int res = Math.min(suf[0], m);
    j = 0;

    for (int i = 0; i < n; i++) {
      if (j < m && s.charAt(i) == t.charAt(j)) {
        int l = j + 1;
        int r = suf[i + 1] - 1;
        if (r >= l) {
          res = Math.min(res, r - l + 1);
        }
        j++;
      }
      res = Math.min(res, m - j);
    }
    return res;
  }
}
