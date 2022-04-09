package code.jam.o2022.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class Weightlifting {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    out.printf("Case #%d: ", testNumber);
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    Map<String, Integer>[] maps = new Map[n + 1];
    for (int i = 0; i <= n; i++) {
      maps[i] = new HashMap<>();
    }
    int inf = (int) 1e8;
    maps[0].put("", 0);
    for (int i = 1; i <= n; i++) {
      for (String s : maps[i - 1].keySet()) {
        Integer prev = maps[i - 1].get(s);
        String cur = toSt(a[i - 1]);
        char[] chars = cur.toCharArray();
        do {
          cur = String.valueOf(chars);
          maps[i].put(cur, Math.min(maps[i].getOrDefault(cur, inf), prev + helper(s, cur)));
        } while (nextPermutation(chars));
      }
    }

    int min = inf;
    for (Integer v : maps[n].values()) {
      min = Math.min(min, v);
    }
    int last = 0;
    for (int i = 0; i < m; i++) {
      last += a[n - 1][i];
    }
    out.println(min + last);
  }

  private Integer helper(String s, String cur) {
    int len = Math.min(s.length(), cur.length());
    int i = 0;
    int res = 0;
    for (; i < len; i++) {
      if (s.charAt(i) != cur.charAt(i)) {
        break;
      }
    }
    res += s.length() - i + cur.length() - i;
    return res;
  }

  private String toSt(int[] ints) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i]; j++) {
        sb.append((i + 1));
      }
    }
    return sb.toString();
  }

  public boolean nextPermutation(char[] s) {
    int n = s.length;
    for (int i = n - 2; i >= 0; i--) {
      if (s[i] < s[i + 1]) {
        reverse(s, i + 1, n - 1);
        for (int j = i + 1; ; j++) {
          if (s[j] > s[i]) {
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            return true;
          }
        }
      }
    }
    return false;
  }

  public void reverse(char[] data, int l, int r) {
    while (l < r) {
      char tmp = data[l];
      data[l] = data[r];
      data[r] = tmp;
      l++;
      r--;
    }
  }
}
