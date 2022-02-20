package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CXeniaAndWeights {
  int n, m;
  String s;
  List<Integer> list;
  Map<String, Boolean> memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    m = in.nextInt();
    for (int i = 0; i < 10; i++) {
      if (s.charAt(i) == '1') {
        list = new ArrayList<>();
        list.add(i + 1);
        memo = new HashMap<>();
        if (dfs(1, i + 1, i + 1)) {
          out.println("YES");
          for (Integer l : list) {
            out.print(l + " ");
          }
          out.println();
          return;
        }
      }
    }
    out.println("NO");

  }

  private boolean dfs(int num, int diff, int last) {
    if (num == m) {
      return true;
    }
    String key = num + " " + diff + " " + last;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    if (diff > 0) {
      for (int i = diff + 1; i <= s.length(); i++) {
        if (s.charAt(i - 1) == '1' && i != last) {
          list.add(i);
          if (dfs(num + 1, diff - i, i)) {
            memo.put(key, true);
            return true;
          }
          list.remove(list.size() - 1);
        }
      }
    } else {
      for (int i = -diff + 1; i <= s.length(); i++) {
        if (s.charAt(i - 1) == '1' && i != last) {
          list.add(i);
          if (dfs(num + 1, diff + i, i)) {
            memo.put(key, true);
            return true;
          }
          list.remove(list.size() - 1);
        }
      }
    }
    memo.put(key, false);
    return false;
  }
}
