package leetcode.C345;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public int[] circularGameLosers(int n, int k) {
    int[] cnt = new int[n];
    int s = 0;
    int t = 1;
    while (cnt[s] < 1) {
      cnt[s]++;
      s = (s + t * k) % n;
      t++;
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (cnt[i] == 0) {
        list.add(i);
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i) + 1;
    }
    return res;
  }
}
