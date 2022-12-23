package nowcoder.courses.dp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  int n, k1, k2, k3, a, b, c;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k1 = in.nextInt();
    k2 = in.nextInt();
    k3 = in.nextInt();
    a = in.nextInt();
    b = in.nextInt();
    c = in.nextInt();
    int sum = k1 + k2 + k3;

    int[] pk = new int[sum + 1];
    for (int i = 1; i <= k1; i++) {
      for (int j = 1; j <= k2; j++) {
        for (int k = 1; k <= k3; k++) {
          if (i == a && j == b && k == c) {
            continue;
          }
          pk[i + j + k]++;
        }
      }
    }
    int mul = k1 * k2 * k3;
    double p0 = 1.0 / mul;
    double[] p = new double[sum + 1];

    for (int i = 0; i <= sum; i++) {
      p[i] = (double) pk[i] / mul;
    }

    double[] x = new double[n + sum + 5];
    double[] y = new double[n + sum + 5];
    for (int i = n; i >= 0; i--) {
      for (int j = 1; j <= sum; j++) {
        x[i] += p[j] * x[i + j];
        y[i] += p[j] * y[i + j];
      }
      x[i] += p0;
      y[i] += 1;
    }

    out.println(y[0] / (1 - x[0]));
  }


}
