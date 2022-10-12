package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DDrEvilUnderscores {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(in.nextInt());
    }

    out.println(dfs(30, set));

  }

  private int dfs(int i, Set<Integer> set) {
    if (i == -1) {
      return 0;
    }
    Set<Integer> a = new HashSet<>();
    Set<Integer> b = new HashSet<>();
    for (Integer v : set) {
      if (((v >> i) & 1) == 1) {
        a.add(v);
      } else {
        b.add(v);
      }
    }
    if (a.size() == 0) {
      return dfs(i - 1, b);
    }
    if (b.size() == 0) {
      return dfs(i - 1, a);
    }
    return Math.min(dfs(i - 1, a) + (1 << i), dfs(i - 1, b) + (1 << i));
  }
}
