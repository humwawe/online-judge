package codeforces.c800;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class EKeshiInSearchOfAmShZ {
  int N = 200010;
  int M = N;
  int[] h2 = new int[N];
  int[] e2 = new int[M];
  int[] ne2 = new int[M];
  int idx2;
  int n;
  int m;
  int[] dist = new int[N];
  boolean[] vis = new boolean[N];
  int inf = (int) 1e15;
  int[] cnt = new int[N];
  Map<Long, Integer> map = new HashMap<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h2, -1);
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add2(b, a);
      cnt[a]++;
      long key = (long) a * N + b;
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    dijkstra();
    out.println(dist[1]);

  }

  void dijkstra() {
    Arrays.fill(dist, inf);
    dist[n] = 0;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new int[]{0, n});
    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int d = poll[0];
      int v = poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = h2[v]; i != -1; i = ne2[i]) {
        int j = e2[i];
        int td = --cnt[j];
        if (dist[j] > d + td + 1) {
          dist[j] = d + td + 1;
          priorityQueue.add(new int[]{dist[j], j});
        }
      }

    }
  }

  private int helper(int u, int v) {
    long key = (long) u * N + v;
    return cnt[u] - map.getOrDefault(key, 0);
  }

  void add2(int a, int b) {
    e2[idx2] = b;
    ne2[idx2] = h2[a];
    h2[a] = idx2++;
  }
}
