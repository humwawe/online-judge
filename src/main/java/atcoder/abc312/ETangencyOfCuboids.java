package atcoder.abc312;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ETangencyOfCuboids {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] cnt = new int[6][100];
    int[][] a = new int[n][6];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 6; j++) {
        int x = in.nextInt();
        cnt[j][x]++;
        a[i][j] = x;
      }
    }

    for (int i = 0; i < n; i++) {
      int t = 0;
      for (int j = 0; j < 6; j++) {
        if (j < 3) {
          t += cnt[j + 3][a[i][j]];
        } else {
          t += cnt[j - 3][a[i][j]];
        }

      }
      out.println(t);
    }

  }


}
