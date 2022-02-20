package acwing.contest.weekly.c35;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] s = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
      s[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt();
    }
    int[] map = new int[n];
    int inf = (int) 1e9;
    Arrays.fill(map, -1);
    for (int i = 0; i < n; i++) {
      int min = inf;
      for (int j = i + 1; j < n; j++) {
        if (s[i] < s[j]) {
          if (c[j] < min) {
            map[i] = j;
            min = c[j];
          }
        }
      }
    }
    int res = inf;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (s[i] < s[j]) {
          if (map[j] != -1) {
            res = Math.min(res, c[i] + c[j] + c[map[j]]);
          }
        }
      }
    }
    if (res == inf) {
      out.println(-1);
    } else {
      out.println(res);
    }
  }
}
