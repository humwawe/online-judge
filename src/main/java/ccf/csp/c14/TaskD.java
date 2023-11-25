package ccf.csp.c14;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


public class TaskD {
  int[] sum, b;
  int n;
  Graph graph;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    b = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      b[i] = in.nextInt();
    }
    sum = new int[n + 1];
    graph = new Graph(n, 3 * n, true);

    for (int i = 2; i < n; i++) {
      graph.add(i - 2, i + 1, b[i] * 3);
      graph.add(i + 1, i - 2, -(b[i] * 3 + 2));
    }
    graph.add(0, 2, b[1] * 2);
    graph.add(2, 0, -(b[1] * 2 + 1));
    graph.add(n - 2, n, b[n] * 2);
    graph.add(n, n - 2, -(b[n] * 2 + 1));
    for (int i = 1; i <= n; i++) {
      graph.add(i - 1, i, 1);
    }
    spfa();
    for (int i = 1; i <= n; i++) {
      out.print(sum[i] - sum[i - 1], "");
    }
    out.println();
  }

  private void spfa() {
    int inf = (int) 1e8;
    Arrays.fill(sum, -inf);
    Queue<Integer> queue = new ArrayDeque<>();
    sum[0] = 0;
    queue.add(0);
    boolean[] vis = new boolean[n + 1];
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      vis[u] = false;
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (sum[j] < sum[u] + graph.w[i]) {
          sum[j] = sum[u] + graph.w[i];
          if (!vis[j]) {
            queue.add(j);
            vis[j] = true;
          }
        }
      }
    }
  }

}
