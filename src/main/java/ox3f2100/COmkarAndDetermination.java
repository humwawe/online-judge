package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class COmkarAndDetermination {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] a = new char[n][m];
    int[] b = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
        if (i > 0 && j > 0 && a[i][j - 1] == 'X' && a[i - 1][j] == 'X') {
          b[j] = 1;
        }
      }
    }

    int[] sum = new int[m + 1];
    for (int i = 0; i < m; i++) {
      sum[i + 1] = sum[i] + b[i];
    }
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      if (sum[r] - sum[l] > 0) {
        out.println("NO");
      } else {
        out.println("YES");
      }
    }
  }
}
