package acwing.contest.weekly.c87;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    int l = 0;
    int r = n - 1;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      int[] b = new int[mid + 1];
      for (int i = 0; i <= mid; i++) {
        b[i] = a[i];
      }
      Arrays.sort(b);
      long t = 0;
      for (int i = mid; i >= 0; i -= 2) {
        t += b[i];
      }
      if (t <= m) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    out.println(l + 1);
  }
}
