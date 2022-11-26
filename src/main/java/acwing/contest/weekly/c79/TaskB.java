package acwing.contest.weekly.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long sum = 0;
    long cur = 1;
    while (sum + cur * 5 < n) {
      sum += cur * 5;
      cur *= 2;
    }
    n -= sum;
    long now = 0;
    for (int i = 0; i < 5; i++) {
      if (now + cur < n) {
        n -= cur;
      } else {
        out.println((char) ('a' + i));
        return;
      }
    }
  }
}
