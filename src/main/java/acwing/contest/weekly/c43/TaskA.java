package acwing.contest.weekly.c43;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        for (int k = j; k <= n; k++) {
          if ((i ^ j ^ k) != 0) {
            continue;
          }
          if (i + j > k && i + k > j && j + k > i) {
            res++;
          }
        }
      }
    }
    out.println(res);
  }
}
