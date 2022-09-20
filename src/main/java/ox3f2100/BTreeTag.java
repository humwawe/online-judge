package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class BTreeTag {
  int n, a, b, da, db;
  int N = (int) (1e5 + 5);
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int[] w = new int[M];
  int idx;
  int[] dis = new int[N];
  boolean[] vis = new boolean[N];
  int point;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = in.nextInt();
    b = in.nextInt();
    da = in.nextInt();
    db = in.nextInt();
    idx = 0;
    for (int i = 1; i <= n; i++) {
      h[i] = -1;
    }

    for (int i = 0; i < n - 1; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      add(x, y);
      add(y, x);
    }
    bfs(1);
    bfs(point);

    int len = dis[point];

    if (2 * da >= Math.min(db, len)) {
      out.println("Alice");
      return;
    }
    bfs(a);

    if (da >= dis[b]) {
      out.println("Alice");
      return;
    }

    out.println("Bob");
  }

  private void bfs(int u) {
    for (int i = 0; i <= n; i++) {
      dis[i] = 0;
      vis[i] = false;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(u);
    vis[u] = true;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = h[cur]; i != -1; i = ne[i]) {
        int j = e[i];
        if (!vis[j]) {
          vis[j] = true;
          dis[j] = dis[cur] + 1;
          queue.add(j);
        }
      }
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
      if (res < dis[i]) {
        res = dis[i];
        point = i;
      }
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
