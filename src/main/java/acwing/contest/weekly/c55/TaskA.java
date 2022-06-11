package acwing.contest.weekly.c55;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      set.add(x);
    }
    for (int i : a) {
      if (set.contains(i)) {
        out.print(i, "");
      }
    }
  }
}
