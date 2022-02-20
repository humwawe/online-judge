package acwing.contest.weekly.c15;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    int k = in.nextInt();
    if (k == 0) {
      out.println(n);
      return;
    }

    long t = n;
    int cnt5 = 0;
    while (t % 5 == 0) {
      t /= 5;
      cnt5++;
    }

    t = n;
    int cnt2 = 0;
    while (t % 2 == 0) {
      t /= 2;
      cnt2++;
    }

    if (Math.min(cnt2, cnt5) >= k) {
      out.println(n);
      return;
    }

    for (int i = cnt2; i < Math.min(k, cnt5); i++) {
      n *= 2;
    }
    for (int i = cnt5; i < Math.min(k, cnt2); i++) {
      n *= 5;
    }
    for (int i = 0; i < k - Math.max(cnt2, cnt5); i++) {
      n *= 10;
    }
    out.println(n);
  }
}
