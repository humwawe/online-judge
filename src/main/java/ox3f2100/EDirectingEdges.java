package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EDirectingEdges {
  int n, m;
  int N = (int) 2e5 + 5;
  int M = (int) 2e5 + 5;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 1; i <= n; i++) {
      h[i] = -1;
    }
    idx = 0;
    int[] deg = new int[n + 1];
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();
      if (t == 1) {
        add(a, b);
        deg[b]++;
      }
      list.add(new int[]{a, b});
    }

    int tot = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 0) {
        queue.add(i);

      }
    }
    int[] sort = new int[n + 1];
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      sort[u] = tot++;
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        deg[j]--;
        if (deg[j] == 0) {
          queue.add(j);
        }
      }
    }
    if (tot < n) {
      out.println("NO");
      return;
    }
    out.println("YES");
    for (int[] es : list) {
      if (sort[es[0]] > sort[es[1]]) {
        out.println(es[1], es[0]);
      } else {
        out.println(es[0], es[1]);
      }

    }

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
