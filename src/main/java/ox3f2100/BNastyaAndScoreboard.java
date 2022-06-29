package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class BNastyaAndScoreboard {
  Map<Integer, String> map = new HashMap<>();
  Map<String, Integer> map2 = new HashMap<>();
  int n, k;
  String[] a;
  int inf = (int) 1e7;
  Boolean[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String[] ss = {"1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010", "1111111", "1111011"};
    for (int i = 0; i < ss.length; i++) {
      map.put(i, ss[i]);
      map2.put(ss[i], i);
    }

    n = in.nextInt();
    k = in.nextInt();
    memo = new Boolean[n + 1][k + 1];
    a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextString();
    }


    if (dfs(0, k)) {
      for (int i = 0; i < n; i++) {
        out.print(map2.get(a[i]));
      }
    } else {
      out.println(-1);
    }
  }

  private int helper(String s, String t) {
    int res = 0;
    for (int i = 0; i < 7; i++) {
      if (s.charAt(i) == '1' && t.charAt(i) == '0') {
        return inf;
      }
      if (s.charAt(i) == '0' && t.charAt(i) == '1') {
        res++;
      }
    }
    return res;
  }

  private boolean dfs(int i, int k) {
    if (k < 0) {
      return false;
    }

    if (i == n) {
      return k == 0;
    }
    if (memo[i][k] != null) {
      return memo[i][k];
    }
    String old = a[i];
    for (int j = 9; j >= 0; j--) {
      a[i] = map.get(j);
      if (dfs(i + 1, k - helper(old, a[i]))) {
        return true;
      }
    }
    a[i] = old;
    return memo[i][k] = false;
  }
}
