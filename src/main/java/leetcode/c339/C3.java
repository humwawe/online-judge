package leetcode.c339;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {

  public int miceAndCheese(int[] reward1, int[] reward2, int k) {
    int n = reward1.length;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }

    Arrays.sort(idx, (x, y) -> -(reward1[x] - reward2[x] - reward1[y] + reward2[y]));
    int res = 0;
    for (int i = 0; i < n; i++) {
      int j = idx[i];
      if (i < k) {
        res += reward1[j];
      } else {
        res += reward2[j];
      }
    }
    return res;
  }
}
