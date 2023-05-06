package acwing.contest.weekly.c102;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      while (x % 2 == 0) {
        x /= 2;
      }
      while (x % 3 == 0) {
        x /= 3;
      }
      set.add(x);
    }
    out.println(set.size() == 1 ? "Yes" : "No");
  }
}
