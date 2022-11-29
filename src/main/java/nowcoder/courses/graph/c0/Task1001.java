package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Task1001 {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] c = new int[n];
    int[] u = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt();
      u[i] = in.nextInt();
      if (c[i] == 0) {
        c[i] -= u[i];
      }
    }

    int[] outDep = new int[n];
    int[] inDep = new int[n];
    Graph graph = new Graph(n, m, true);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int w = in.nextInt();
      graph.add(a, b, w);
      outDep[a]++;
      inDep[b]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (inDep[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = graph.h[cur]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (c[cur] > 0) {
          c[j] += graph.w[i] * c[cur];
        }
        if (--inDep[j] == 0) {
          queue.add(j);
        }
      }
    }

    boolean flag = true;
    for (int i = 0; i < n; ++i) {
      if (outDep[i] == 0 && c[i] > 0) {
        out.println((i + 1), c[i]);
        flag = false;
      }
    }
    if (flag) {
      out.println("NULL");
    }
  }
}
