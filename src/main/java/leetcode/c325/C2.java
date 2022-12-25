package leetcode.c325;

/**
 * @author hum
 */
public class C2 {
  public int takeCharacters(String s, int k) {
    int n = s.length();
    if (k == 0) {
      return 0;
    }
    int[][] suf = new int[n + 1][3];

    for (int i = n - 1; i >= 0; i--) {
      int x = s.charAt(i) - 'a';
      for (int j = 0; j < 3; j++) {
        suf[i][j] = suf[i + 1][j];
      }
      suf[i][x]++;
    }

    int j = 0;
    for (int i = 0; i < 3; i++) {
      if (suf[j][i] < k) {
        return -1;
      }
    }
    int res = n;

    while (j + 1 < n + 1 && suf[j + 1][0] >= k && suf[j + 1][1] >= k && suf[j + 1][2] >= k) {
      j++;
    }
    res = n - j;

    int[][] pre = new int[n][3];
    j = 1;
    for (int i = 0; i < n; i++) {
      int x = s.charAt(i) - 'a';
      if (i > 0) {
        for (int l = 0; l < 3; l++) {
          pre[i][l] = pre[i - 1][l];

        }
      }
      pre[i][x]++;

      while (j + 1 < n + 1 && pre[i][0] + suf[j + 1][0] >= k && pre[i][1] + suf[j + 1][1] >= k && pre[i][2] + suf[j + 1][2] >= k) {
        j++;
      }
      res = Math.min(res, i + 1 + n - j);
    }
    return res;
  }


}
