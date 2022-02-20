package acwing.contest.weekly.c34;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    a = in.nextInt();
    int sum = 0;
    for (int i = 2; i <= a - 1; i++) {
      sum += helper(i);
    }
    int x = gcd(sum, a - 2);
    out.print(sum / x);
    out.print("/");
    out.println((a - 2) / x);
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }

  private int helper(int i) {
    int t = a;
    int res = 0;
    while (t > 0) {
      res += t % i;
      t /= i;
    }
    return res;
  }
}
