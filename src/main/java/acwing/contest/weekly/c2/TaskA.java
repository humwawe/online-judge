package acwing.contest.weekly.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskA {
  int N = (int) (1e5 + 5);
  int M = (int) (2e5 + 5);

  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  long[] w = new long[M];
  int idx;

  int n, m, k;
  long inf = (long) 1e15;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    Arrays.fill(h, -1);
    idx = 0;
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int v = in.nextInt();
      add(a, b, v);
      add(b, a, v);
    }
    long[] dist = new long[n + 1];
    boolean[] vis = new boolean[n + 1];
    Arrays.fill(dist, inf);
    dist[1] = 0;
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a.di));
    int[] res = new int[Math.min(k, n - 1)];
    priorityQueue.add(new Node(0, 1, -1));
    int cnt = 0;
    while (!priorityQueue.isEmpty()) {
      Node poll = priorityQueue.poll();
      long d = poll.di;
      int v = poll.vi;
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      if (v != 1) {
        res[cnt++] = poll.ei / 2 + 1;
      }

      if (cnt >= k) {
        break;
      }
      if (cnt == n - 1) {
        break;
      }
      for (int i = h[v]; i != -1; i = ne[i]) {
        int j = e[i];
        if (dist[j] > d + w[i]) {
          dist[j] = d + w[i];
          priorityQueue.add(new Node(dist[j], j, i));
        }
      }
    }
    out.println(res.length);
    for (int re : res) {
      out.print(re + " ");
    }

  }

  void add(int a, int b, int v) {
    e[idx] = b;
    w[idx] = v;
    ne[idx] = h[a];
    h[a] = idx++;
  }

  class Node {
    long di;
    int vi;
    int ei;

    public Node(long di, int vi, int ei) {
      this.di = di;
      this.vi = vi;
      this.ei = ei;
    }
  }
}
