package acwing.contest.weekly.c44;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (a > 0) {
        set.add(a);
      }
    }
    out.println(set.size());
  }
}
