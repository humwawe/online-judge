package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CMinimumSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] base = new int[]{1, 10, 100, 1000, 10000, 100000};
    int[] cnt = new int[10];
    boolean[] can = new boolean[10];
    Arrays.fill(can, true);
    for (int i = 0; i < n; i++) {
      String s = in.nextString();
      can[s.charAt(0) - 'a'] = false;
      for (int j = 0; j < s.length(); j++) {
        cnt[s.charAt(j) - 'a'] += base[s.length() - j - 1];
      }
    }
    Integer[] idx = new Integer[10];
    for (int i = 0; i < 10; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, (x, y) -> cnt[y] - cnt[x]);
    boolean[] vis = new boolean[10];
    long res = 0;
    for (int i = 0; i < 10; i++) {
      Integer j = idx[i];
      if (can[j] && !vis[0]) {
        vis[0] = true;
      } else {
        for (int k = 1; k < 10; k++) {
          if (!vis[k]) {
            vis[k] = true;
            res += k * cnt[j];
            break;
          }
        }
      }
    }
    out.println(res);
  }
}
