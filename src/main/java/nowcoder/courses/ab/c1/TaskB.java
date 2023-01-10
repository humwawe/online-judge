package nowcoder.courses.ab.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskB {
  Map<String, Boolean> memo = new HashMap<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    if (s.charAt(0) == '0') {
      out.println("Yes");
      return;
    }
    if (dfs(s)) {
      out.println("Yes");
    } else {
      out.println("No");
    }

  }

  private boolean dfs(String s) {
    if (s.length() == 0) {
      return false;
    }
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    char[] chars = s.toCharArray();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == '0') {
        String ns = s.substring(0, i);
        if (!dfs(ns)) {
          memo.put(s, true);
          return true;
        }
      } else if (c > '0') {
        for (char j = '0'; j < c; j++) {
          chars[i] = j;
          String ns = new String(chars);
          if (!dfs(ns)) {
            memo.put(s, true);
            return true;
          }
          chars[i] = c;
        }
      }
    }
    memo.put(s, false);
    return false;

  }
}
