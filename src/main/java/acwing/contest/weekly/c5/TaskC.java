package acwing.contest.weekly.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskC {
  int N = 2010;

  long[] dist = new long[N];
  boolean[] vis = new boolean[N];

  int M = N * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  long[] w = new long[M];
  int idx;
  int[][] a;
  int[] c;
  int[] k;

  // dijkstra在更新距离时候的有变形，思路其实是求最小生成树的prim
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    int n = in.nextInt();
    a = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    c = new int[n + 1];
    k = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      c[i] = in.nextInt();
    }
    for (int i = 1; i <= n; i++) {
      k[i] = in.nextInt();
    }
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        add(i, j, helper(i, j));
        add(j, i, helper(i, j));
      }
    }
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(x -> x.d));
    for (int i = 1; i <= n; i++) {
      dist[i] = c[i];
      priorityQueue.add(new Node(c[i], i, i, true));
    }
    long sum = 0;
    List<Integer> cnt = new ArrayList<>();
    List<int[]> list = new ArrayList<>();
    while (!priorityQueue.isEmpty()) {
      Node poll = priorityQueue.poll();
      long d = poll.d;
      int v = poll.p;
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      if (poll.isF) {
        cnt.add(v);
        sum += c[v];
      } else {
        list.add(new int[]{poll.prev, v});
        sum += helper(poll.prev, v);
      }
      for (int i = h[v]; i != -1; i = ne[i]) {
        int j = e[i];
        if (dist[j] > w[i]) {
          dist[j] = w[i];
          priorityQueue.add(new Node(dist[j], j, v, false));
        }
      }
    }
    out.println(sum);
    out.println(cnt.size());
    for (Integer integer : cnt) {
      out.print(integer + " ");
    }
    out.println();
    out.println(list.size());
    for (int[] points : list) {
      out.println(points[0] + " " + points[1]);
    }

  }

  class Node {
    long d;
    int p;
    int prev;
    boolean isF;

    public Node(long d, int p, int prev, boolean isF) {
      this.d = d;
      this.p = p;
      this.isF = isF;
      this.prev = prev;
    }
  }

  private long helper(int i, int j) {
    long d = Math.abs(a[i][0] - a[j][0]) + Math.abs(a[i][1] - a[j][1]);
    return d * (k[i] + k[j]);
  }

  void add(int a, int b, long v) {
    e[idx] = b;
    w[idx] = v;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
