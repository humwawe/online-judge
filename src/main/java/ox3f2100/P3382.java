package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.function.DoubleUnaryOperator;

public class P3382 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    double l = in.nextDouble();
    double r = in.nextDouble();
    double[] a = new double[n + 1];
    for (int i = 0; i <= n; i++) {
      a[i] = in.nextDouble();
    }
    out.println(ternarySearch((x -> {
      double sum = 0;
      for (int i = 0; i <= n; i++) {
        sum = sum * x + a[i];
      }
      return sum;
    }), l, r));

  }

  double ternarySearch(DoubleUnaryOperator op, double l, double r) {
    final double eps = 1e-6;
    while (r - l > eps) {
      double k = (r - l) / 3;
      double ml = l + k;
      double mr = r - k;
      if (op.applyAsDouble(ml) < op.applyAsDouble(mr)) {
        l = ml;
      } else {
        r = mr;
      }
    }
    return l;
  }
}
