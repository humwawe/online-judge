package acwing.contest.weekly.c47;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[k];
    boolean[] vis = new boolean[n];
    for (int i = 0; i < k; i++) {
      a[i] = in.nextInt();
    }
    int start = 0;
    for (int i = 0; i < k; i++) {
      int size = n - i;
      int t = a[i] % size;
      for (int j = 0; j < t; ) {
        start = (start + 1) % n;
        if (!vis[start]) {
          j++;
        }
      }
      vis[start] = true;
      out.print(start + 1, "");
      start = (start + 1) % n;
      while (vis[start]) {
        start = (start + 1) % n;
      }
    }
    out.println();
  }
}
