package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJzzhuAndCities {
  int N = 100010;
  int M = N * 8;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] w = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m, k;
  long[] dist = new long[N];
  boolean[] vis = new boolean[N];
  int[] cnt = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      add(a, b, c);
      add(b, a, c);
    }
    int[][] tmp = new int[k][2];
    for (int i = 0; i < k; i++) {
      int v = in.nextInt();
      int d = in.nextInt();
      add(1, v, d);
      add(v, 1, d);
      tmp[i][0] = v;
      tmp[i][1] = d;
    }
    dijkstra();
    int res = 0;
    for (int ii = 0; ii < k; ii++) {
      int v = tmp[ii][0];
      long d = tmp[ii][1];
      if (dist[v] < d) {
        res++;
      }
      if (dist[v] == d && cnt[v] > 1) {
        res++;
        cnt[v]--;
      }

    }
    out.println(res);

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
      // 第一次弹出即是最短的距离，无法处理负数（存在负数使得第一次弹出可能并不是最小值）
      vis[v] = true;
      for (int i = h[v]; i != -1; i = ne[i]) {
        int j = e[i];
        if (dist[j] == d + w[i]) {
          cnt[j]++;
        }
        if (dist[j] > d + w[i]) {
          dist[j] = d + w[i];
          priorityQueue.add(new long[]{dist[j], j});
          cnt[j] = 1;
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
