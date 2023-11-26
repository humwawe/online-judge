package leetcode.b118;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    Arrays.sort(hBars);
    Arrays.sort(vBars);
    int len1 = 0;
    for (int i = 0; i < hBars.length; i++) {
      int j = i;
      while (j + 1 < hBars.length && hBars[j + 1] == hBars[j] + 1) {
        j++;
      }
      len1 = Math.max(len1, j - i + 1);
      i = j;
    }
    int len2 = 0;
    for (int i = 0; i < vBars.length; i++) {
      int j = i;
      while (j + 1 < vBars.length && vBars[j + 1] == vBars[j] + 1) {
        j++;
      }
      len2 = Math.max(len2, j - i + 1);
      i = j;
    }
    int t = Math.min(len1, len2);
    return (t + 1) * (t + 1);
  }
}
