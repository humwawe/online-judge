package ccf.csp.c14;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][2];
    int[][] b = new int[n][2];
    int N = (int) 1e6 + 5;
    int[] cnt = new int[N];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
      for (int j = a[i][0]; j < a[i][1]; j++) {
        cnt[j]++;
      }
    }
    for (int i = 0; i < n; i++) {
      b[i][0] = in.nextInt();
      b[i][1] = in.nextInt();
      for (int j = b[i][0]; j < b[i][1]; j++) {
        cnt[j]++;
      }
    }
    int res = 0;
    for (int i = 0; i < N; i++) {
      if (cnt[i] == 2) {
        res++;
      }
    }
    out.println(res);
  }
}
