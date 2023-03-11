package acwing.contest.weekly.c94;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskC {
  long[][] dist;
  long inf = (long) 1e15;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[][] a = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int[] b = in.nextInt(n);
    dist = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else {
          dist[i][j] = inf;
        }
      }
    }
    long[] res = new long[n];
    boolean[] vis = new boolean[n];
    for (int t = 0; t < n; t++) {
      int k = b[n - 1 - t] - 1;
      vis[k] = true;
      for (int i = 0; i < n; i++) {
        if (vis[i]) {
          dist[k][i] = Math.min(dist[k][i], a[k][i]);
          dist[i][k] = Math.min(dist[i][k], a[i][k]);
        }
      }
      long sum = 0;

      long[] dijkstra = dijkstra(n, k);
      for (int i = 0; i < n; i++) {
        dist[k][i] = Math.min(dist[k][i], dijkstra[i]);
      }
      long[] dijkstra2 = dijkstra2(n, k);
      for (int i = 0; i < n; i++) {
        dist[i][k] = Math.min(dist[i][k], dijkstra2[i]);
      }


      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] < inf) {
            sum += dist[i][j];
          }
        }
      }

      res[n - 1 - t] = sum;
    }
    out.println(res);

  }

  public long[] dijkstra(int n, int s) {
    long[] dis = new long[n];
    boolean[] vis = new boolean[n];
    Arrays.fill(dis, inf);
    dis[s] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, s});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];

      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = 0; i < n; i++) {
        if (i == v) {
          continue;
        }
        if (dis[i] > d + dist[v][i]) {
          dis[i] = d + dist[v][i];
          priorityQueue.add(new long[]{dis[i], i});
        }
      }
    }
    return dis;
  }

  public long[] dijkstra2(int n, int s) {
    long[] dis = new long[n];
    boolean[] vis = new boolean[n];
    Arrays.fill(dis, inf);
    dis[s] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, s});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];

      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = 0; i < n; i++) {
        if (dis[i] > d + dist[i][v]) {
          dis[i] = d + dist[i][v];
          priorityQueue.add(new long[]{dis[i], i});
        }
      }
    }
    return dis;
  }
}
