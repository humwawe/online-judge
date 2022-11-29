package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Task1003 {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Graph graph = new Graph(n, m, true);

    int[] inDep = new int[n];
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      inDep[a]++;
      graph.add(b, a);
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
    for (int i = 0; i < n; i++) {
      if (inDep[i] == 0) {
        queue.add(i);
      }
    }
    List<Integer> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int u = queue.poll();
      res.add(u + 1);
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (--inDep[j] == 0) {
          queue.add(j);
        }
      }
    }

    if (res.size() != n) {
      out.println("Impossible!");
    } else {
      Collections.reverse(res);
      out.println(res);
    }
  }
}
