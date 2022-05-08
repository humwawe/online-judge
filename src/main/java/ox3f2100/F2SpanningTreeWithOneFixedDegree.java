package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class F2SpanningTreeWithOneFixedDegree {
  int N = (int) (2e5 + 5);
  int M = 2 * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m, d;
  int[] p = new int[N];
  int[] ch = new int[N];
  int cnt = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    d = in.nextInt();
    Arrays.fill(h, -1);
    for (int i = 0; i <= n; i++) {
      p[i] = i;
    }


    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      if (a > b) {
        int t = a;
        a = b;
        b = t;
      }
      if (a == 1) {
        ch[++cnt] = b;
      } else {
        union(a, b);
        add(a, b);
        add(b, a);
      }
    }
    int num = 0;
    for (int i = 2; i <= n; i++) {
      if (p[i] == i) {
        num++;
      }
    }
    if (d > cnt || d < num) {
      out.println("NO");
      return;
    }
    out.println("YES");

    boolean[] vis = new boolean[n + 1];
    for (int i = 1; i <= cnt; i++) {
      if (vis[find(ch[i])]) {
        continue;
      }
      vis[find(ch[i])] = true;
      add(1, ch[i]);
      add(ch[i], 1);
      ch[i] = -1;
      d--;
    }
    if (d > 0) {
      for (int i = 1; i <= cnt && d > 0; i++) {
        if (ch[i] == -1) {
          continue;
        }
        add(1, ch[i]);
        add(ch[i], 1);
        d--;
      }
    }

    vis = new boolean[n + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    vis[1] = true;
    while (!queue.isEmpty()) {
      int p = queue.poll();
      for (int i = h[p]; i != -1; i = ne[i]) {
        int j = e[i];
        if (!vis[j]) {
          queue.add(j);
          vis[j] = true;
          out.println(p, j);
        }
      }
    }
  }


  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  void union(int a, int b) {
    if (find(a) == find(b)) {
      return;
    }
    p[find(a)] = find(b);
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
