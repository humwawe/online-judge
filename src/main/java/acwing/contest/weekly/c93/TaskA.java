package acwing.contest.weekly.c93;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long k = in.nextInt();
    long x = (n + k - 1) / k;
    if (n % k == 0) {
      x++;
    }
    out.println(x * k);
  }
}
