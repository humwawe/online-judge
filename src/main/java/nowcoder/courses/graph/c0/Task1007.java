package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Dijkstra;
import util.Graph;

public class Task1007 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int s = in.nextInt();
    int t = in.nextInt();
    Graph graph = new Graph(n, m);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    Dijkstra dijkstra = new Dijkstra();
    long[] dist = dijkstra.dijkstra(graph, s);
    if (dist[t] != dijkstra.inf) {
      out.println(dist[t]);
    } else {
      out.println(-1);
    }
  }


}
