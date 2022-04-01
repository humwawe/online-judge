package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeSet;

public class F1NearestBeautifulNumberEasyVersion {
  TreeSet<Long> set2 = new TreeSet<>();
  TreeSet<Long> set1 = new TreeSet<>();

  {
    for (int i = 0; i <= 9; i++) {
      for (int j = i + 1; j <= 9; j++) {
        dfs(i, j, 0, 0, 0);
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    int k = in.nextInt();
    if (k == 1) {
      out.println(set1.ceiling(n));
    } else {
      out.println(set2.ceiling(n));
    }

  }

  private void dfs(int i, int j, int pos, long res, int use) {
    if (pos > 10) {
      return;
    }
    set2.add(res);
    if (use != 3) {
      set1.add(res);
    }
    dfs(i, j, pos + 1, res * 10 + i, use | 1);
    dfs(i, j, pos + 1, res * 10 + j, use | 2);
  }

}
