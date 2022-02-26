package acwing.contest.weekly.c40;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Set<Integer> set = new HashSet<>();
    set.add(1);
    int a = 1;
    int b = 1;
    for (int i = 2; i < 1000; i++) {
      int c = a + b;
      set.add(c);
      a = b;
      b = c;
    }
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      if (set.contains(i)) {
        out.print("O");
      } else {
        out.print("o");
      }
    }
    out.println();
  }
}
