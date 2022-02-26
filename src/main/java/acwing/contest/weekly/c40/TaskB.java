package acwing.contest.weekly.c40;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    int res = 0;
    for (int i = 1; i < n; i++) {
      if (a[i] <= a[i - 1]) {
        res += a[i - 1] + 1 - a[i];
        a[i] = a[i - 1] + 1;
      }
    }
    out.println(res);
  }
}
