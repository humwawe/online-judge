package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CCheckposts {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    int[] v = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      v[i] = in.nextInt();
    }
    m = in.nextInt();
    for (int i = 1; i <= m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
    }
    for (int i = 1; i <= n; i++) {
      if (dfn[i] == 0) {
        tarjanScc(i);
      }
    }
    int mod = 1000000007;
    long res1 = 0;
    long res2 = 1;
    for (int i = 1; i <= sccCnt; i++) {
      int cnt = 0;
      int min = (int) 1e9 + 5;
      for (Integer p : sccList[i]) {
        if (v[p] < min) {
          min = v[p];
          cnt = 1;
        } else if (v[p] == min) {
          cnt++;
        }
      }
      res1 += min;
      res2 = res2 * cnt % mod;
    }
    out.println(res1, res2);
  }

  private void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }


  int N = (int) (1e5 + 5);
  int M = (int) (3e5 + 5);
  int[] dfn = new int[N];
  int[] low = new int[N];

  int timestamp;

  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx, top;
  int n, m;

  // 强连通个数
  int sccCnt = 0;
  // 某个点属于哪个强连通分量
  int[] sccC = new int[N];
  // 每个联通分量的点
  List<Integer>[] sccList = new List[N];
  int[] sccStack = new int[N];
  boolean[] inSccStack = new boolean[N];

  // 有向图的强联通分量
  void tarjanScc(int u) {
    dfn[u] = low[u] = ++timestamp;
    sccStack[++top] = u;
    inSccStack[u] = true;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (dfn[j] == 0) {
        tarjanScc(j);
        low[u] = Math.min(low[u], low[j]);
      } else if (inSccStack[j]) {
        low[u] = Math.min(low[u], dfn[j]);
      }
    }
    // 联通分量编号递减即是拓扑序
    if (dfn[u] == low[u]) {
      ++sccCnt;
      sccList[sccCnt] = new ArrayList<>();
      int y;
      do {
        y = sccStack[top--];
        inSccStack[y] = false;
        sccC[y] = sccCnt;
        sccList[sccCnt].add(y);
      } while (y != u);
    }
  }
}
