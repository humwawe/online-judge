package acwing.contest.weekly.c41;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    Set<Integer> set = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      a = a - x;
      b = b - y;
      int t = gcd(Math.abs(a), Math.abs(b));
      a /= t;
      b /= t;
      if (a * b < 0) {
        set2.add(Math.abs(a) * (int) 1e5 + Math.abs(b));
      } else {
        set.add(Math.abs(a) * (int) 1e5 + Math.abs(b));
      }

    }
    out.println(set.size() + set2.size());
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
