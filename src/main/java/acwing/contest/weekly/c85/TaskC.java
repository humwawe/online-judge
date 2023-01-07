package acwing.contest.weekly.c85;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.DJSet;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    DJSet djSet = new DJSet(n);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      djSet.unite(a, b);
    }

    int[][] bs = djSet.toBucket();
    long res = 1;
    for (int i = 0; i < n; i++) {
      if (bs[i] == null) {
        continue;
      }
      int size = bs[i].length - 1;
      for (int j = 0; j < size; j++) {
        res *= 2;
      }
    }
    out.println(res);
  }
}
