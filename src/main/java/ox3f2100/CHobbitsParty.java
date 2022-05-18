package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CHobbitsParty {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = 0;
    while (m * (m + 1) <= 2 * n) {
      m++;
    }
    int[][] res = new int[210][210];
    int cnt1 = 0;
    for (int i = 1; i <= m - 1; i++) {
      for (int j = i; j <= m - 1; j++) {
        res[i][j] = ++cnt1;
      }
    }
    int cnt2 = 0;
    for (int j = 1; j <= m - 1; j++) {
      for (int i = j + 1; i <= m; i++) {
        res[i][j] = ++cnt2;
      }
    }
    out.println(m);
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= m - 1; j++) {
        out.print(res[i][j], "");
      }
      out.println();
    }
  }
}
