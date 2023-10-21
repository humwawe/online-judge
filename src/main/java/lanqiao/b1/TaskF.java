package lanqiao.b1;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.FenwickTree;

import java.util.Arrays;

public class TaskF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    int N = (int) 2e5 + 5;
    int[][] a = new int[n + q][3];
    int[] sum = new int[N];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
      a[i][2] = -1;
      sum[a[i][0]]++;
      sum[a[i][1] + 1]--;
    }

    for (int i = 0; i < N - 1; i++) {
      sum[i + 1] += sum[i];
    }

    int[] res = new int[q];
    for (int i = 0; i < q; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      a[i + n][0] = Math.min(x, y);
      a[i + n][1] = Math.max(x, y);
      a[i + n][2] = i;

      res[i] = sum[x];
    }

    Arrays.sort(a, (x, y) -> {
      int d = x[0] - y[0];
      if (d == 0) {
        return x[2] - y[2];
      }
      return d;
    });

    FenwickTree fenwickTree = new FenwickTree(N);

    for (int i = 0; i < n + q; i++) {

      if (a[i][2] < 0) {
        fenwickTree.add(a[i][1], 1);
      } else {
        res[a[i][2]] -= fenwickTree.getSum(a[i][1], N - 1);
      }
    }
    for (int i = 0; i < q; i++) {
      out.println(res[i]);
    }
  }
}
