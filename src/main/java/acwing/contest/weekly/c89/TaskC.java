package acwing.contest.weekly.c89;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    int N = (int) (n + 5);
    long[] dist = new long[N];
    boolean[] vis = new boolean[N];
    Arrays.fill(dist, (long) 1e15);
    dist[0] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, 0});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      if (v == n) {
        out.println(dist[n]);
        return;
      }
      int j = v - 1;
      if (j > 0 && j < N) {
        if (dist[j] > d + x) {
          dist[j] = d + x;
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
      j = v + 1;
      if (j > 0 && j < N) {
        if (dist[j] > d + x) {
          dist[j] = d + x;
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
      j = v * 2;
      if (j > 0 && j < N) {
        if (dist[j] > d + y) {
          dist[j] = d + y;
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }
    out.println(dist[n]);
  }
}
