package acwing.contest.weekly.c12;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();
    boolean[] vis = new boolean[26];
    for (char c : s.toCharArray()) {
      vis[c - 'a'] = true;
    }
    int min = 26;
    for (int i = 0; i < 26; i++) {
      if (vis[i]) {
        min = i;
        break;
      }
    }
    StringBuilder res = new StringBuilder();
    if (k > n) {
      res.append(s);
      for (int i = 0; i < 26; i++) {
        if (vis[i]) {
          for (int j = 0; j < k - n; j++) {
            res.append((char) ('a' + i));
          }
          out.println(res.toString());
          return;
        }
      }
    } else {
      boolean f = false;
      g:
      for (int i = k - 1; i >= 0; i--) {
        int tmp = s.charAt(i) - 'a';
        if (!f) {
          for (int j = tmp + 1; j < 26; j++) {
            if (vis[j]) {
              res.insert(0, (char) ('a' + j));
              f = true;
              continue g;
            }
          }
        }
        if (f) {
          res.insert(0, s.charAt(i));
        } else {
          res.append((char) (min + 'a'));
        }
      }
    }

    out.println(res.toString());
  }
}
