package acwing.contest.weekly.c49;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int y = in.nextInt();
      if (y + k <= 5) {
        cnt++;
      }
    }
    out.println(cnt / 3);
  }
}
