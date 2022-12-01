package nowcoder.courses.math.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    int[][] fac = divide2(x);
    int[] v = fac[0];
    int[] cnt = fac[1];
    int res = 0;
    for (int value : cnt) {
      res += value;
    }
    long res2 = 1;
    for (int i = 1; i <= res; i++) {
      res2 *= i;
    }
    for (int value : cnt) {
      for (int i = 1; i <= value; i++) {
        res2 /= i;
      }
    }
    out.println(res, res2);

  }

  int[][] divide2(int x) {
    int len = 0;
    int N = 65;
    int[] p = new int[N];
    int[] t = new int[N];
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        p[len] = i;
        t[len] = 0;
        while (x % i == 0) {
          t[len]++;
          x /= i;
        }
        len++;
      }
    }
    if (x > 1) {
      p[len] = x;
      t[len] = 1;
      len++;
    }
    return new int[][]{Arrays.copyOf(p, len), Arrays.copyOf(t, len)};
  }
}
