package acwing.contest.weekly.c23;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    for (int i = n - 1; i >= 0; i--) {
      if (!check(a[i])) {
        out.println(a[i]);
        return;
      }
    }
  }

  private boolean check(int i) {
    int a = (int) (Math.sqrt(i) + 0.5);
    return a * a == i;
  }
}
