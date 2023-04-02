package leetcode.b101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public long makeSubKSumEqual(int[] arr, int k) {
    int n = arr.length;
    boolean[] vis = new boolean[n];
    long res = 0;
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        List<Integer> list = new ArrayList<>();
        for (int j = i; ; j = (j + k) % n) {
          if (vis[j]) {
            break;
          }
          vis[j] = true;
          list.add(arr[j]);
        }
        res += helper(list);
      }

    }
    return res;
  }

  private long helper(List<Integer> list) {
    Collections.sort(list);
    int t = list.get(list.size() / 2);
    long res = 0;
    for (Integer integer : list) {
      res += Math.abs(integer - t);
    }
    return res;
  }
}
