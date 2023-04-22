package leetcode.lc2023f;

/**
 * @author hum
 */
public class C1 {
  public int[] supplyWagon(int[] supplies) {
    int n = supplies.length;
    int[] res = supplies.clone();
    while (res.length != n / 2) {
      res = helper(res);
    }
    return res;

  }

  private int[] helper(int[] res) {
    int[] ret = new int[res.length - 1];
    int idx = 0;
    int sum = res[0] + res[1];
    for (int i = 1; i < res.length - 1; i++) {
      if (res[i] + res[i + 1] < sum) {
        sum = res[i] + res[i + 1];
        idx = i;
      }
    }

    int c = 0;
    for (int i = 0; i < res.length; i++) {
      if (c == idx) {
        ret[c] = res[idx] + res[idx + 1];
        i++;
      } else {
        ret[c] = res[i];
      }
      c++;
    }
    return ret;
  }
}
