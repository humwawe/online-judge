package acwing.contest.weekly.c121;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] idx = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt() - 1;
      idx[a[i]] = i;
    }
    int[] b = in.nextInt(m);

    long res = 0;

    for (int i = 0; i < m; i++) {
      int c = b[i] - 1;
      int j = idx[c];
      res += (j / k) + 1;
      if (j == 0) {
        continue;
      }

      int pre = j - 1;
      int t = idx[c];
      idx[c] = idx[a[pre]];
      idx[a[pre]] = t;

      t = a[pre];
      a[pre] = a[j];
      a[j] = t;
    }
    out.println(res);

  }
}
