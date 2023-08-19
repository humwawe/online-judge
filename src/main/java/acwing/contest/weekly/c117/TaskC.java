package acwing.contest.weekly.c117;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.HashMap;
import java.util.Map;

public class TaskC {
  int res = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<String, Integer> map = new HashMap<>();
    map.put("bessie", 0);
    Graph graph = new Graph(n + 1, 2 * n + 5, true);
    int idx = 1;
    for (int i = 0; i < n; i++) {
      String a = in.nextString().toLowerCase();
      String b = in.nextString().toLowerCase();

      if (!map.containsKey(a)) {
        map.put(a, idx++);
      }
      if (!map.containsKey(b)) {
        map.put(b, idx++);
      }
      graph.add(map.get(b), map.get(a));
    }

    dfs(graph, 0, 1);

    out.println(res);
  }

  private void dfs(Graph graph, int u, int dep) {
    res = Math.max(res, dep);
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      dfs(graph, j, dep + 1);
    }
  }
}
