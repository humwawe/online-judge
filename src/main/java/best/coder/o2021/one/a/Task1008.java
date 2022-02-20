package best.coder.o2021.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task1008 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] type = new int[n];
    int u = -1;
    for (int i = 0; i < n; i++) {
      type[i] = in.nextInt();
      if (type[i] == 1) {
        u = i;
      }
    }
    int[][] mat = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = in.nextInt() - 1;
      }
    }
    boolean[] death = new boolean[n];
    int last = n;
    int[] pos = new int[n];
    int d = mat[u][pos[u]++];
    if (!death[d]) {
      death[d] = true;
      last--;
      if (death[u]) {
        out.println("lieren");
        return;
      }
      if (last <= 2) {
        out.println("langren");
        return;
      }
    }
    while (true) {
      int nd = mat[d][pos[d]++];
      while (death[nd]) {
        nd = mat[d][pos[d]++];
      }
      death[nd] = true;
      last--;
      if (death[u]) {
        out.println("lieren");
        return;
      }
      if (last <= 2) {
        out.println("langren");
        return;
      }
      d = nd;
    }
  }
}
