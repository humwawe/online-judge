package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class ABook {
  int N = (int) (2e5 + 5);
  int M = N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    idx = 0;
    for (int i = 1; i <= n; i++) {
      h[i] = -1;
    }

    int[] inDeg = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int x = in.nextInt();
        add(x, i);
        inDeg[i]++;
      }
    }
    int[] dist = new int[n + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (inDeg[i] == 0) {
        queue.add(i);
        dist[i] = 1;
      }
    }

    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        inDeg[j]--;
        int t = j > u ? 0 : 1;
        dist[j] = Math.max(dist[j], dist[u] + t);
        if (inDeg[j] == 0) {
          queue.add(j);
        }
      }
    }

    int res = 0;
    for (int i = 1; i <= n; i++) {
      if (inDeg[i] != 0) {
        out.println(-1);
        return;
      }
      res = Math.max(res, dist[i]);
    }
    out.println(res);
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
