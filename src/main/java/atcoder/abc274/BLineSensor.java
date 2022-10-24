package atcoder.abc274;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BLineSensor {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] a = new char[n][m];
    int[] res = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
        res[j] += a[i][j] == '#' ? 1 : 0;
      }
    }
    out.println(res);
  }
}
