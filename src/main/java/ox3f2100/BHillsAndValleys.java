package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BHillsAndValleys {
  int n;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int sum = 0;
    for (int i = 1; i < n - 1; i++) {
      sum += check(i);
    }
    int res = sum;
    for (int i = 1; i < n - 1; i++) {
      int t = a[i];
      int v = sum - check(i - 1) - check(i) - check(i + 1);
      a[i] = a[i - 1];
      res = Math.min(res, v + check(i - 1) + check(i) + check(i + 1));
      a[i] = a[i + 1];
      res = Math.min(res, v + check(i - 1) + check(i) + check(i + 1));
      a[i] = t;
    }

    out.println(res);

  }

  int check(int x) {
    if (x <= 0 || x >= n - 1) {
      return 0;
    }
    return ((a[x] < a[x - 1]) && (a[x] < a[x + 1])) || ((a[x] > a[x - 1]) && (a[x] > a[x + 1])) ? 1 : 0;
  }
}