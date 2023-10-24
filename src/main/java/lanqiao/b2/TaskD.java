package lanqiao.b2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt();
    Graph graph = new Graph(n, n - 1, true);
    int[] dep = new int[n + 1];
    int[] s = new int[n + 1];
    int[] k = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      s[i] = b;
      k[i] = c;
      if (i == 1) {
        continue;
      }
      graph.add(a, i);
      dep[i]++;
    }


    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> k[x]));
    for (int i = 1; i <= n; i++) {
      if (dep[i] == 0) {
        queue.add(i);
      }
    }

    int res = 0;
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      if (p >= k[u]) {
        p += s[u];
        res += 1;
      } else {
        break;
      }
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (--dep[j] == 0) {
          queue.add(j);
        }
      }
    }
    out.println(res);

  }
}
