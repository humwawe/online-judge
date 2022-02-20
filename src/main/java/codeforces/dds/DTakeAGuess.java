package codeforces.dds;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

// a+b=(a&b)<<1+(a^b)
// a+b=(a&b)+(a|b)
public class DTakeAGuess {

  InputReader in;
  OutputWriter out;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int s12 = add(1, 2) + or(1, 2);
    int s13 = add(1, 3) + or(1, 3);
    int s23 = add(2, 3) + or(2, 3);
    a[0] = (s12 + s13 - s23) / 2;
    a[1] = s13 - a[0];
    a[2] = s23 - a[1];

    for (int i = 3; i < n; i++) {
      int s = add(1, i + 1) + or(1, i + 1);
      a[i] = s - a[0];
    }
    Arrays.sort(a);
    finish(a[k - 1]);
  }

  int add(int x, int y) {
    out.println("and " + x + " " + y);
    out.flush();
    return in.nextInt();
  }

  int or(int x, int y) {
    out.println("or " + x + " " + y);
    out.flush();
    return in.nextInt();
  }

  void finish(int x) {
    out.println("finish " + x);
    out.flush();
  }
}
