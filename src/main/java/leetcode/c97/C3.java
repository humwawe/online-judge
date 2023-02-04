package leetcode.c97;

/**
 * @author hum
 */
public class C3 {

  public int maximizeWin(int[] prizePositions, int k) {
    int n = prizePositions.length;
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      int end = prizePositions[i] + k;
      int l = i;
      int r = n - 1;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        if (prizePositions[mid] <= end) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      c[i] = l - i + 1;
    }

    int[] suf = new int[n];
    suf[n - 1] = c[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      suf[i] = Math.max(c[i], suf[i + 1]);
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, c[i] + (i + c[i] >= n ? 0 : suf[i + c[i]]));
    }
    return res;
  }
}
