package acwing.contest.weekly.c75;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      a[i] = in.nextInt();
    }
    int x = in.nextInt() - 1;
    int y = in.nextInt() - 1;
    int sum = 0;
    for (int i = x; i < y; i++) {
      sum += a[i];
    }
    out.println(sum);
  }
}
