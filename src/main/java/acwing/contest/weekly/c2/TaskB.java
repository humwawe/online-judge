package acwing.contest.weekly.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  int n, k;

  // 最大的k+1个数
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    if (n == 1) {
      out.println(0);
      return;
    }
    int start = n - 2;
    long sum = a[n - 1];
    while (start >= 0 && k-- > 0) {
      if (a[start] > 0) {
        sum += a[start];
        start--;
      } else {
        break;
      }
    }
    out.println(sum);
  }
}
