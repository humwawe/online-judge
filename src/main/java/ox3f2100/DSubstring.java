package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DSubstring {
  int n, m;
  String s;
  int N = (int) (3e5 + 5);
  int[] h = new int[N];
  int[] e = new int[N];
  int[] ne = new int[N];
  int idx;


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    s = in.nextString();
    int[] deg = new int[n + 1];
    int[][] val = new int[n + 1][26];
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      deg[b]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    int vis = 0;
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 0) {
        val[i][s.charAt(i - 1) - 'a']++;
        queue.add(i);
        vis++;
      }
    }
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        deg[j]--;
        for (int k = 0; k < 26; k++) {
          int t = 0;
          if (k == s.charAt(j - 1) - 'a') {
            t = 1;
          }
          val[j][k] = Math.max(val[j][k], val[u][k] + t);
        }
        if (deg[j] == 0) {
          queue.add(j);
          vis++;
        }
      }
    }
    if (vis != n) {
      out.println(-1);
      return;
    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 26; j++) {
        max = Math.max(max, val[i][j]);
      }
    }
    out.println(max);
  }

  private void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
