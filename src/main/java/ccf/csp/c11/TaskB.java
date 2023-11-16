package ccf.csp.c11;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i;
      w[i] = i;
    }
    int[][] b = new int[k * 2][3];
    for (int i = 0; i < k; i++) {
      int x = in.nextInt() - 1;
      int s = in.nextInt();
      int t = in.nextInt();
      b[i * 2][0] = x;
      b[i * 2][1] = s;
      b[i * 2][2] = 1;
      b[i * 2 + 1][0] = x;
      b[i * 2 + 1][1] = s + t;
      b[i * 2 + 1][2] = -1;
    }
    Arrays.sort(b, (x, y) -> {
      int d = x[1] - y[1];
      if (d == 0) {
        if (x[2] - y[2] == 0) {
          return x[0] - y[0];
        }
        return x[2] - y[2];
      }
      return d;
    });
    PriorityQueue<Integer> pr = new PriorityQueue();
    for (int[] cur : b) {
      if (cur[2] == -1) {
        int idx = pr.poll();
        a[idx] = cur[0];
        w[cur[0]] = idx;
      } else {
        pr.add(w[cur[0]]);
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(a[i] + 1, "");
    }
    out.println();

  }
}
