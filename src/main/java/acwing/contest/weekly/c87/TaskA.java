package acwing.contest.weekly.c87;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = 0;
    int y = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        int t = in.nextInt();
        if (t == 1) {
          x = i;
          y = j;
        }
      }
    }
    out.println(Math.abs(x - 2) + Math.abs(y - 2));
  }
}
