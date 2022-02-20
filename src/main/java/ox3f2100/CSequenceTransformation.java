package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CSequenceTransformation {
  List<Integer> res = new ArrayList<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    dfs(n, 1);
    for (Integer i : res) {
      out.print(i, "");
    }
  }

  private void dfs(int n, int i) {
    if (n == 3) {
      res.add(i);
      res.add(i);
      res.add(i * 3);
      return;
    }
    if (n == 2) {
      res.add(i);
      res.add(i * 2);
      return;
    }
    if (n == 1) {
      res.add(i);
      return;
    }
    for (int j = 1; j <= n; j += 2) {
      res.add(i);
    }
    dfs(n / 2, i * 2);
  }
}
