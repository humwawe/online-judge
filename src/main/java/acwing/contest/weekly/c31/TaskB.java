package acwing.contest.weekly.c31;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int p = in.nextInt();
    p = Math.min(p, in.nextInt());
    p = Math.min(p, in.nextInt());
    p = Math.min(p, in.nextInt());
    int a = in.nextInt();
    int b = in.nextInt();
    int res = 0;
    for (int i = a; i <= b; i++) {
      if (i < p) {
        res++;
      }
    }
    out.println(res);
  }
}
