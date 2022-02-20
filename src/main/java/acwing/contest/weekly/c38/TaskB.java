package acwing.contest.weekly.c38;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskB {
  int N = 20010;
  boolean[] vis = new boolean[N];
  int[] dist = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(n);
    dist[n] = 0;
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      if (poll == m) {
        out.println(dist[poll]);
        return;
      }
      int a = poll * 2;
      if (a < N && dist[a] == 0) {
        queue.add(a);
        dist[a] = dist[poll] + 1;
      }
      int b = poll - 1;
      if (dist[b] == 0 && b > 0) {
        queue.add(b);
        dist[b] = dist[poll] + 1;
      }
    }
  }
}
