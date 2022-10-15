package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DMouseHunt {
  int n;
  int[] c;
  int ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    c = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      c[i] = in.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      int x = in.nextInt();
      add(i, x);
      add(x, i);
    }
    for (int i = 1; i <= n; i++) {
      if (dfn[i] == 0) {
        dfsCycle(i);
      }
    }
    out.println(ans);
  }

  int N = (int) (2e5 + 5);
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] w = new int[M];
  int[] ne = new int[M];
  int idx;
  int[] dfn = new int[N];
  // 根据点标号如果已经有0，考虑初始化为-1
  int[] fa = new int[N];
  int timestamp = 0;
  // 存上环的点
  int[] s = new int[N];
  // 记录环上边的权值
  // int[] edge = new int[N];
  int p = 0;

  // 无向图dfs找环
  // 标定时间戳，如果访问到已经访问的点，且不是父节点，且时间戳大于当前的说明有环
  void dfsCycle(int u) {
    dfn[u] = ++timestamp;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (dfn[j] == 0) {
        // 记录边的信息
        fa[j] = i;
        dfsCycle(j);
      }
      // 碰到环，取等于可以找自环
      else if ((i ^ 1) != fa[u] && dfn[j] >= dfn[u]) {
        ans += getCycle(u, j, w[i]);
        return;
      }
    }
  }

  int getCycle(int u, int j, int z) {
    int min = (int) 1e8;
    while (j != u) {
      s[p++] = j;
      min = Math.min(min, c[j]);
      // edge[p] = w[fa[j]];
      j = e[fa[j] ^ 1];
    }
    s[p++] = u;
    min = Math.min(min, c[u]);
    return min;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
