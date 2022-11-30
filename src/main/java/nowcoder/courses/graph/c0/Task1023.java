package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class Task1023 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] c = new int[n + 1];
    int[] inDep = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int x = in.nextInt();
      c[i] = x;
      inDep[x]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] vis = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      if (inDep[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      vis[u] = true;
      if (--inDep[c[u]] == 0) {
        queue.add(c[u]);
      }
    }
    int res = (int) 1e8;
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        int t = i;
        int cnt = 1;
        vis[t] = true;
        while (c[t] != i) {
          cnt++;
          t = c[t];
          vis[t] = true;
        }
        res = Math.min(res, cnt);
      }
    }
    out.println(res);
  }
}
