package leetcode.b101;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {
  public int findShortestCycle(int n, int[][] edges) {
    Arrays.fill(h, -1);
    for (int i = edges.length - 1; i >= 0; i--) {
      int[] edge = edges[i];
      add(edge[0], edge[1]);
      add(edge[1], edge[0]);
    }
    for (int i = 0; i < n; i++) {
      bfs(i);
    }
    if (ans == 1005) {
      return -1;
    }
    return ans;

  }

  int N = 1005;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;

  int ans = 1005;

  void bfs(int s) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(s);
    int[] dis = new int[N];
    int[] fa = new int[N];
    Arrays.fill(dis, -1);
    dis[s] = 0;
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (dis[j] < 0) {
          fa[j] = i;
          dis[j] = dis[u] + 1;
          queue.add(j);
        } else if ((i ^ 1) != fa[u]) {
          ans = Math.min(ans, dis[j] + dis[u] + 1);
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







