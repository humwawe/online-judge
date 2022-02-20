package acwing.contest.weekly.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TaskC {
  int n, m;
  int N = (int) (2e5 + 5);
  int[] h = new int[N];
  int[] e = new int[N];
  int[] ne = new int[N];
  int idx;
  int[] p;
  int s, t;
  int[] d = new int[N];
  int[] cnt = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(b, a);
    }
    int k = in.nextInt();
    int[] p = new int[k];
    for (int i = 0; i < k; i++) {
      p[i] = in.nextInt();
    }
    s = p[0];
    t = p[k - 1];
    bfs();
    int a0 = 0, a1 = 0;
    for (int i = 0; i < k - 1; i++) {
      if (d[p[i]] != d[p[i + 1]] + 1) {
        a0++;
        a1++;
      } else {
        if (cnt[p[i]] > 1) {
          a1++;
        }
      }
    }
    out.println(a0 + " " + a1);
  }

  void bfs() {
    int inf = (int) 1e8;
    Arrays.fill(d, inf);
    cnt[t] = 1;
    d[t] = 0;
    Queue<Integer> q = new ArrayDeque<>();
    q.add(t);
    while (!q.isEmpty()) {
      int u = q.poll();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (d[u] + 1 < d[j]) {
          d[j] = d[u] + 1;
          cnt[j] = 1;
          q.add(j);
        } else if (d[u] + 1 == d[j]) {
          cnt[j]++;
        }
      }
    }
  }


  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
