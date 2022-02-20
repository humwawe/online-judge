package acwing.contest.weekly.c14;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][3];
    for (int i = 0; i < n; i++) {
      a[i][0] = i;
      a[i][1] = in.nextInt();
      a[i][2] = in.nextInt();
    }
    int[] res = new int[n];

    int j = 0;
    for (int i = 1; i < 5005; ) {
      if (j == n) {
        break;
      }
      if (a[j][2] < i) {
        res[j] = 0;
        j++;
        continue;
      }
      if (a[j][1] <= i) {
        res[j++] = i;
      }
      i++;
    }
    out.println(res);

  }
}
