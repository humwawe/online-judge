package ccf.csp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.*;

public class TaskD {
  int n, m;
  Graph graph;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    graph = new Graph(n, 2 * m, true);
    List<Integer>[] lists = new List[n + 1];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      lists[a].add(b);
      lists[b].add(a);
    }
    int cnt = 0;
    for (int i = 0; i < n + 1; i++) {
      lists[i].sort((x, y) -> y - x);
      if (lists[i].size() % 2 == 1) {
        cnt++;
      }
    }
    if (cnt != 0 && cnt != 2 || cnt == 2 && lists[1].size() % 2 == 0) {
      out.println(-1);
    } else {
      for (int u = 0; u < n + 1; u++) {
        for (Integer v : lists[u]) {
          graph.add(u, v);
        }
      }
      dfs(1);
      if (res[m] == 0) {
        out.println(-1);
        return;
      }
      for (int i = t - 1; i >= 0; i--) {
        out.print(res[i], "");
      }
      out.println();
    }


  }

  Set<Integer> set = new HashSet<>();
  int base = (int) 1e5;
  int M = 100005;
  int[] res = new int[M];
  int t = 0;

  void dfs(int u) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      int edge = u * base + j;
      if (!set.contains(edge)) {
        set.add(edge);
        set.add(j * base + u);
        dfs(j);
      }
    }

    res[t++] = u;
  }
}
