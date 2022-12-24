package leetcode.cc94;

/**
 * @author hum
 */
public class C1 {
  public int captureForts(int[] forts) {
    int n = forts.length;

    int res = 0;
    for (int i = 0; i < n; i++) {
      if (forts[i] == 1) {
        int cnt = 0;
        for (int j = i + 1; j < n; j++) {
          if (forts[j] == 0) {
            cnt++;
          } else if (forts[j] == -1) {
            res = Math.max(res, cnt);
            break;
          } else {
            break;
          }
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      if (forts[i] == 1) {
        int cnt = 0;
        for (int j = i - 1; j >= 0; j--) {
          if (forts[j] == 0) {
            cnt++;
          } else if (forts[j] == -1) {
            res = Math.max(res, cnt);
            break;
          } else {
            break;
          }
        }
      }
    }
    return res;
  }
}
