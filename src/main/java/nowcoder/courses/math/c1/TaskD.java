package nowcoder.courses.math.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();
    int n = 1;
    for (int i = 0; i < k; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      for (int j = 0; j < b; j++) {
        n *= a;
      }
    }
    int x = n - 1;
    int[][] ints = divide2(x);
    for (int i = ints[0].length - 1; i >= 0; i--) {
      out.print(ints[0][i], ints[1][i], "");
    }

    out.println();

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
