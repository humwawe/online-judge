package acwing.contest.weekly.c77;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();

    out.println(gcd(n - 1, m - 1) + 1);

  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
