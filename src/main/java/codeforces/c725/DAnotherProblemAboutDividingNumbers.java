package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DAnotherProblemAboutDividingNumbers {
  int a, b, k;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    a = in.nextInt();
    b = in.nextInt();
    k = in.nextInt();
    int sum1 = divide(a);
    int sum2 = divide(b);
    int hi = sum1 + sum2;
    int lo = (a % b == 0 || b % a == 0) && a != b ? 1 : 2;
    if (lo <= k && k <= hi) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }


  int divide(int x) {
    int res = 0;
    for (int i = 2; i * i <= x; i++) {
      while (x % i == 0) {
        x /= i;
        res++;
      }
    }
    if (x > 1) {
      res++;
    }
    return res;
  }
}
