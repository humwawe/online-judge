package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class CDijkstra {
  int N = (int) 1e5 + 5;

  long[] dist = new long[N];
  boolean[] vis = new boolean[N];
  int M = 2 * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int[] w = new int[M];
  int idx;
  int[] prev = new int[N];
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      add(a, b, c);
      add(b, a, c);
    }
    dijkstra();
    if (dist[n] == 1e15) {
      out.println(-1);
      return;
    }
    int cur = n;
    List<Integer> list = new ArrayList<>();
    list.add(n);
    while (prev[cur] != 1) {
      cur = prev[cur];
      list.add(cur);
    }
    list.add(1);
    for (int i = list.size() - 1; i >= 0; i--) {
      out.print(list.get(i), "");
    }
  }

  void dijkstra() {
    Arrays.fill(dist, (long) 1e15);
    dist[1] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, 1});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = h[v]; i != -1; i = ne[i]) {
        int j = e[i];
        if (dist[j] > d + w[i]) {
          prev[j] = v;
          dist[j] = d + w[i];
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }
  }

  void add(int a, int b, int v) {
    e[idx] = b;
    w[idx] = v;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
