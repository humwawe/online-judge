package acwing.contest.weekly.c95;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

import java.util.HashSet;
import java.util.Set;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int N = (int) 1e6 + 5;
    int[] siev = MathMeth.sieveEratosthenes(N);
    Set<Long> set = new HashSet<>();
    for (int i : siev) {
      set.add((long) i * i);
    }

    for (int i = 0; i < n; i++) {
      long x = in.nextLong();
      if (set.contains(x)) {
        out.println("YES");
      } else {
        out.println("NO");
      }
    }
  }
}
