package acwing.contest.weekly.c46;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      c[i] = a[i] - b[i];
    }

    Arrays.sort(c);

    int i = n - 1;
    for (; i >= k; i--) {
      if (c[i] > 0) {
        sum -= c[i];
      } else {
        break;
      }
    }

    out.println(sum);
  }
}
