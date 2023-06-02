package codeforces.c855;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class FDashaAndNightmares {
  String[] ss;
  int n;
  Map<Integer, Integer>[] map = new Map[2];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    map[0] = new HashMap<>();
    map[1] = new HashMap<>();
    ss = new String[n];
    for (int i = 0; i < n; i++) {
      ss[i] = in.nextString();
    }

    long res = 0;
    for (char i = 'a'; i <= 'z'; i++) {
      res += helper(i);
    }
    out.println(res);
  }

  private long helper(char c) {
    map[0].clear();
    map[1].clear();
    long res = 0;
    for (int i = 0; i < n; i++) {
      if (ss[i].indexOf(c) != -1) {
        continue;
      }
      int cur = 0;
      int len = ss[i].length();
      for (int j = 0; j < len; j++) {
        cur ^= 1 << (ss[i].charAt(j) - 'a');
      }

      int need = ((1 << 26) - 1) ^ cur;
      need ^= 1 << (c - 'a');
      res += map[1 - len % 2].getOrDefault(need, 0);

      map[len % 2].put(cur, map[len % 2].getOrDefault(cur, 0) + 1);
    }
    return res;
  }
}
