package codeforces.c825;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BPlayingWithGCD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n + 1];
    Arrays.fill(b, 1);

    for (int i = 0; i < n; i++) {
      b[i] = lcm(a[i], b[i]);
      b[i + 1] = lcm(a[i], b[i + 1]);
    }

    for (int i = 0; i < n; i++) {
      if (a[i] != gcd(b[i], b[i + 1])) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }

  int lcm(int a, int b) {
    int g = gcd(a, b);
    return a / g * b;
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
