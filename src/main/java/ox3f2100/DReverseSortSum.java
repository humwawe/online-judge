package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DReverseSortSum {
  int N = 200005;
  int[] t = new int[N];

  int lowbit(int x) {
    return x & -x;
  }

  void add(int x, int c) {
    for (int i = x; i <= n; i += lowbit(i)) {
      t[i] += c;
    }
  }

  int sum(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += t[i];
    }
    return res;
  }

  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    Arrays.fill(t, 1, n + 5, 0);
    int[] a = new int[n + 1];
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    int[] res = new int[n];
    int k = (int) (sum / n);

    for (int i = n; i > 0; i--) {
      if (a[i] + sum(i) == i) {
        res[i - 1] = 1;
      } else {
        res[i - 1] = 0;
      }
      add(i - k + 1, -1);
      if (res[i - 1] == 1) {
        k--;
      }
    }

    out.println(res);
  }
}
