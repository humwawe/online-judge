package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class Task1008 {
  int[] p;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    p = new int[n + 1];
    Edge[] edges = new Edge[m];
    for (int i = 0; i < m; i++) {
      edges[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
    }
    Arrays.sort(edges, Comparator.comparingLong(a -> a.w));
    for (int i = 1; i <= n; i++) {
      p[i] = i;
    }
    long res = 0;
    for (int i = 0; i < m; i++) {
      int a = edges[i].a;
      int b = edges[i].b;
      long w = edges[i].w;
      a = find(a);
      b = find(b);
      if (a != b) {
        res += w;
        p[a] = b;
      }
    }
    out.println(res);
  }

  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  class Edge {
    int a;
    int b;
    long w;

    public Edge(int a, int b, int w) {
      this.a = a;
      this.b = b;
      this.w = w;
    }
  }
}
