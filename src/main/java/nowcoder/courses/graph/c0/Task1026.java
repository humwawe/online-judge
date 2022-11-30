package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task1026 {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int s = in.nextInt();
    double t = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();

    double[] x = new double[s * 4 + 5];
    double[] y = new double[s * 4 + 5];
    double[] cost = new double[s];
    for (int i = 0; i < s; i++) {

      x[i * 4] = in.nextDouble();
      y[i * 4] = in.nextDouble();
      x[i * 4 + 1] = in.nextDouble();
      y[i * 4 + 1] = in.nextDouble();
      x[i * 4 + 2] = in.nextDouble();
      y[i * 4 + 2] = in.nextDouble();
      cost[i] = in.nextDouble();

      double dab = ds(x[i * 4], y[i * 4], x[i * 4 + 1], y[i * 4 + 1]);
      double dac = ds(x[i * 4], y[i * 4], x[i * 4 + 2], y[i * 4 + 2]);
      double dbc = ds(x[i * 4 + 1], y[i * 4 + 1], x[i * 4 + 2], y[i * 4 + 2]);

      if (doubleComp(dab + dac, dbc)) {
        x[i * 4 + 3] = x[i * 4 + 1] + x[i * 4 + 2] - x[i * 4];
        y[i * 4 + 3] = y[i * 4 + 1] + y[i * 4 + 2] - y[i * 4];
      } else if (doubleComp(dab + dbc, dac)) {
        x[i * 4 + 3] = x[i * 4] + x[i * 4 + 2] - x[i * 4 + 1];
        y[i * 4 + 3] = y[i * 4] + y[i * 4 + 2] - y[i * 4 + 1];
      } else if (doubleComp(dbc + dac, dab)) {
        x[i * 4 + 3] = x[i * 4 + 1] + x[i * 4] - x[i * 4 + 2];
        y[i * 4 + 3] = y[i * 4 + 1] + y[i * 4] - y[i * 4 + 2];
      }
    }
    double[][] dist = new double[s * 4][s * 4];
    for (int i = 0; i < s * 4; i++) {
      for (int j = 0; j < s * 4; j++) {
        if (i / 4 != j / 4) {
          dist[i][j] = t * dis(x[i], y[i], x[j], y[j]);
        } else {
          dist[i][j] = cost[i / 4] * dis(x[i], y[i], x[j], y[j]);
        }
      }
    }
    for (int k = 0; k < 4 * s; k++) {
      for (int i = 0; i < 4 * s; i++) {
        for (int j = 0; j < 4 * s; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
    double res = Double.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        res = Math.min(res, dist[(a - 1) * 4 + i][(b - 1) * 4 + j]);
      }
    }
    out.printf("%.1f", res);

  }

  double eps = 1e-8;

  boolean doubleComp(double a, double b) {
    // a == b
    return sgn(a - b) == 0;
  }

  int sgn(double a) {
    return a < -eps ? -1 : a < eps ? 0 : 1;
  }

  double dis(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  }

  double ds(double x1, double y1, double x2, double y2) {
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
  }


}
