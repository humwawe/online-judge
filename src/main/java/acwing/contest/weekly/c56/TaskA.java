package acwing.contest.weekly.c56;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int max = 0;
    int[] cnt = new int[105];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      cnt[a[i]]++;
      max = Math.max(max, cnt[a[i]]);
    }
    out.println(max);
  }
}
