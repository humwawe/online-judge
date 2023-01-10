package codeforces.c843;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

import java.util.*;

public class DFriendlySpiders {
  int N = (int) (3e5 + 5);
  int[] ps;

  {
    ps = MathMeth.sieveLowestPrime(N);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int s = in.nextInt() - 1;
    int t = in.nextInt() - 1;

    if (s == t) {
      out.println(1);
      out.println(s + 1);
      return;
    }

    List<Integer>[] p2i = new List[N];
    Arrays.setAll(p2i, e -> new ArrayList<>());
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int[][] ret = MathMeth.mulDivide(a[i], ps);
      for (int i1 = 0; i1 < ret.length; i1++) {
        p2i[ret[i1][0]].add(i);
      }
    }

    int[] dist = new int[n + N];
    int[] pre = new int[n + N];
    boolean[] vis = new boolean[n + N];
    Arrays.fill(dist, -1);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(s);

    dist[s] = 0;
    pre[s] = -1;


    while (!queue.isEmpty()) {
      int u = queue.poll();
      if (vis[u]) {
        continue;
      }
      vis[u] = true;
      if (u >= n) {
        for (Integer i : p2i[u - n]) {
          if (!vis[i]) {
            pre[i] = u;
            dist[i] = dist[u] + 1;
            queue.add(i);
          }
        }
      } else {
        int[][] ret = MathMeth.mulDivide(a[u], ps);
        for (int[] pri : ret) {
          if (!vis[n + pri[0]]) {
            pre[n + pri[0]] = u;
            dist[n + pri[0]] = dist[u] + 1;
            queue.add(n + pri[0]);
          }
        }
      }
    }

    if (dist[t] == -1) {
      out.println(-1);
      return;
    }

    List<Integer> res = new ArrayList<>();
    res.add(t + 1);
    while (pre[t] != -1) {
      if (pre[t] < n) {
        res.add(pre[t] + 1);
      }
      t = pre[t];
    }

    Collections.reverse(res);
    out.println(res.size());
    out.println(res);
  }
}
