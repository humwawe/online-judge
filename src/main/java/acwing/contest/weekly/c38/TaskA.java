package acwing.contest.weekly.c38;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int l = 0;
    int r = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      if (a > 0) {
        r++;
      } else {
        l++;
      }
    }
    if (l > 1 && r > 1) {
      out.println("No");
    } else {
      out.println("Yes");
    }
  }
}
