package acwing.contest.weekly.c41;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskC {
  int N = 200010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, q;
  List<Integer> res = new ArrayList<>();
  Map<Integer, Integer> map = new HashMap<>();
  int pos;
  int[] size = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    pos = 0;
    n = in.nextInt();
    q = in.nextInt();
    for (int i = 2; i <= n; i++) {
      int a = in.nextInt();
      add(i, a);
      add(a, i);
    }
    dfs(1, 1);
    for (int i = 0; i < q; i++) {
      int a = in.nextInt();
      int k = in.nextInt();
      if (size[a] < k) {
        out.println(-1);
      } else {
        out.println(res.get(map.get(a) + k - 1));
      }
    }
  }

  private void dfs(int u, int p) {
    res.add(u);
    map.put(u, pos++);
    size[u]++;
    List<Integer> list = new ArrayList<>();
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      list.add(j);
    }
    Collections.sort(list);
    for (Integer j : list) {
      dfs(j, u);
      size[u] += size[j];
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
