package codeforces.c789;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTokitsukazeAndStrangeInequality {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    long res = 0;
    for (int i = 1; i <= n - 2; i++) {

      for (int j = 1; j <= n; j++) {
        t[j] = 0;
        t2[j] = 0;
      }

      for (int j = i + 3; j <= n; j++) {
        add(a[j], 1);
      }
      add2(a[i + 1], 1);
      int sum = sum(a[i + 1]);
      for (int j = i + 2; j <= n - 1; j++) {

        if (a[i] < a[j]) {
          res += sum;
        }

        add(a[j + 1], -1);
        sum -= (sum2(n) - sum2(a[j + 1]));
        add2(a[j], 1);
        sum += sum(a[j]);
      }

    }

    out.println(res);
  }

  int N = 5005;
  int[] t = new int[N];
  int[] t2 = new int[N];

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

  void add2(int x, int c) {
    for (int i = x; i <= n; i += lowbit(i)) {
      t2[i] += c;
    }
  }

  int sum2(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += t2[i];
    }
    return res;
  }

}
