package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CGameWithChips {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    for (int i = 0; i < 2 * k; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < n - 1; i++) {
      res.append('U');
    }
    for (int i = 0; i < m - 1; i++) {
      res.append('L');
    }
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        res.append('D');
      }
      if (i % 2 == 0) {
        for (int j = 0; j < m - 1; j++) {
          res.append('R');
        }
      } else {
        for (int j = 0; j < m - 1; j++) {
          res.append('L');
        }
      }
    }
    out.println(res.length());
    out.println(res.toString());
  }
}
