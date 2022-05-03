package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CHarmonyAnalysis {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 0) {
      out.println('+');
      return;
    }
    List<String> list = dfs(n, 1);
    for (String s : list) {
      out.println(s);
    }
  }

  private List<String> dfs(int n, int t) {
    List<String> res = new ArrayList<>();
    if (n == 1) {
      if (t == 1) {
        res.add("++");
        res.add("+*");
        return res;
      } else {
        res.add("**");
        res.add("*+");
        return res;
      }
    }

    List<String> r1 = dfs(n - 1, t);
    List<String> r2 = dfs(n - 1, t);
    List<String> r3 = dfs(n - 1, t);
    List<String> r4 = dfs(n - 1, -t);

    int size = r1.size();
    for (int i = 0; i < size; i++) {
      res.add(r1.get(i) + r2.get(i));
    }
    for (int i = 0; i < size; i++) {
      res.add(r3.get(i) + r4.get(i));
    }
    return res;
  }
}
