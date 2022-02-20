package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DTaskOnTheBoard {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    int m = in.nextInt();
    int[] a = new int[m];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
      sb.append("?");
    }

    int z = 0;
    boolean[] vis = new boolean[m];

    while (true) {
      List<Integer> list = new ArrayList<>();
      boolean f = false;
      for (int i = 0; i < m; i++) {
        if (a[i] == z && !vis[i]) {
          list.add(i);
          vis[i] = true;
          f = true;
        }
      }
      if (!f) {
        break;
      }
      for (int i = 25; i >= 0; i--) {
        if (cnt[i] >= list.size()) {
          for (Integer j : list) {
            sb.setCharAt(j, (char) ('a' + i));
            for (int x = 0; x < m; x++) {
              if (a[x] > z && !vis[x]) {
                a[x] -= Math.abs(x - j);
              }
            }
          }
          cnt[i] = 0;
          break;
        } else {
          cnt[i] = 0;
        }
      }
    }
    out.println(sb.toString());
  }
}
