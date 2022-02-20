package acwing.contest.weekly.c19;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
    }
    Arrays.sort(a);
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + a[i];
    }
    if (a[0] == a[n - 1]) {
      out.println(0);
      return;
    }
    int j = n - 2;
    int res = 0;
    while (j >= 0) {
      int len = n - j - 1;
      if (sum[n] - sum[j + 1] - a[j] * len <= k) {
        j--;
      } else {
        len = len - 1;
        long last = k - (sum[n] - sum[j + 2] - a[j + 1] * len);
        long tmp = a[j + 1] - last / (len + 1);
        sum[n] = sum[j + 1] + tmp * (len + 1);
        a[j + 1] = tmp;
        res++;
      }
    }
    out.println(res + 1);
  }
}
