package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int t = in.nextInt();
    int N = 62;
    long[][] c = new long[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          c[i][j] = 1;
        } else {
          c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]);
        }
      }
    }
    long res = 0;
    for (int i = 1; i <= m; i++) {
      int a = i;
      int b = t - i;
      if (b < 4 || a < 1) {
        continue;
      }
      res += c[m][a] * c[n][b];
    }
    out.println(res);
  }


}
