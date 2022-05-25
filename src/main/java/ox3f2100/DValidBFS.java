package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DValidBFS {
  int N = 200010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    idx = 0;
    Arrays.fill(h, -1);
    n = in.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    boolean[] vis = new boolean[n + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    vis[1] = true;
    if (a[1] != 1) {
      out.println("No");
      return;
    }
    int idx = 2;
    while (!queue.isEmpty()) {
      int u = queue.poll();
      Set<Integer> set = new HashSet<>();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (vis[j]) {
          continue;
        }

        vis[j] = true;
        set.add(j);
      }
      for (int i = idx; i < idx + set.size(); i++) {
        if (set.contains(a[i])) {
          queue.add(a[i]);
        } else {
          out.println("No");
          return;
        }
      }
      idx += set.size();
    }

    out.println("Yes");

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
