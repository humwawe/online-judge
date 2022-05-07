package codeforces.c788;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BDormsWar {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int m = in.nextInt();
    boolean[] vis = new boolean[26];
    for (int i = 0; i < m; i++) {
      char c = in.nextCharacter();
      vis[c - 'a'] = true;
    }
    int res = 0;
    int last = 0;
    for (int i = 0; i < n; i++) {
      if (vis[s.charAt(i) - 'a']) {
        res = Math.max(res, i - last);
        last = i;
      }
    }
    out.println(res);
  }
}
