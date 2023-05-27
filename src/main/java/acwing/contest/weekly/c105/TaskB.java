package acwing.contest.weekly.c105;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] res = new int[n + 1];
    for (int i = 0; i < n; i++) {
      int[] cnt = new int[n + 1];
      int max = 0;
      int ele = 0;
      for (int j = i; j < n; j++) {
        cnt[a[j]]++;
        if (cnt[a[j]] > max) {
          max = cnt[a[j]];
          ele = a[j];
        } else if (cnt[a[j]] == max && a[j] < ele) {
          ele = a[j];
        }

        res[ele]++;
      }
    }
    for (int i = 1; i <= n; i++) {
      out.print(res[i], "");
    }
    out.println();
  }
}
