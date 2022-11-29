package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.*;

public class Task1012 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int s = in.nextInt();
    int t = in.nextInt();
    int[] a = new int[m + 1];
    int[] b = new int[m + 1];
    int[] c = new int[m + 1];
    Graph graph = new Graph(n, (int) 1e5 + 5);
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= m; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
      c[i] = in.nextInt();
      int[] tmp = new int[c[i]];
      for (int j = 0; j < c[i]; j++) {
        tmp[j] = in.nextInt();
        if (tmp[j] == s) {
          list.add(i);
        }
      }
      for (int j = 1; j < tmp.length; j++) {
        graph.add(tmp[j - 1], tmp[j], i);
      }
    }

    for (Integer i : list) {
      graph.add(0, s, i);
    }
    if (s == t) {
      out.println(0);
      return;
    }
    long[][] dist = new long[n + 1][m + 1];
    boolean[][] vis = new boolean[n + 1][m + 1];
    long inf = (long) 1e16;
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dist[i], inf);
    }
    dist[0][0] = 0;

    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
    priorityQueue.add(new long[]{0, 0, 0});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];
      int l = (int) poll[2];
      if (vis[v][l]) {
        continue;
      }
      vis[v][l] = true;
      for (int i = graph.h[v]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        int line = graph.w[i];
        if (dist[j][line] > d + (l == 0 ? 0 : b[line]) + (line == l ? 0 : a[line])) {
          dist[j][line] = d + (l == 0 ? 0 : b[line]) + (line == l ? 0 : a[line]);
          priorityQueue.add(new long[]{dist[j][line], j, line});
        }
      }
    }
    long res = inf;
    for (int i = 1; i <= m; i++) {
      res = Math.min(res, dist[t][i]);
    }
    if (res == inf) {
      out.println(-1);
    } else {
      out.println(res);
    }
  }


}
