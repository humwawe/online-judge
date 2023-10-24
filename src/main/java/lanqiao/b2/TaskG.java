package lanqiao.b2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskG {
  int n, q;
  int[] v;
  Graph graph;
  int[] inDfs;
  int[] outDfs;
  int tot;
  List<Integer>[] lists;
  int maxDep;
  int[] depP;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    q = in.nextInt();
    v = in.nextInt(n);

    graph = new Graph(n, n - 1, true);
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      graph.add(a, b);
    }
    inDfs = new int[n];
    outDfs = new int[n];
    lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());
    depP = new int[n];

    dfs(0, 0);

    SparseTable[] sts = new SparseTable[maxDep + 1];
    for (int i = 0; i < maxDep + 1; i++) {
      sts[i] = new SparseTable(lists[i]);
    }

    for (int i = 0; i < q; i++) {
      int x = in.nextInt() - 1;
      int k = in.nextInt();
      int curDep = depP[x] + k;
      List<Integer> tmp = lists[curDep];
      //      int l = 0;
      //      int r = tmp.size() - 1;
      //      while (l < r) {
      //        int mid = l + r >> 1;
      //        if (isAn(x, tmp.get(mid))) {
      //          r = mid;
      //        } else {
      //          l = mid + 1;
      //        }
      //      }
      //      int left = l;
      //

      int left = tmp.size() - 1;
      for (int j = 0; j < tmp.size(); j++) {
        if (isAn(x, tmp.get(j))) {
          left = Math.min(left, j);
          break;
        }
      }
      int l = left;
      int r = tmp.size() - 1;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        if (isAn(x, tmp.get(mid))) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      int right = l;
      out.println(sts[curDep].query(left, right));
    }

  }

  void dfs(int u, int dep) {
    lists[dep].add(u);
    depP[u] = dep;
    inDfs[u] = ++tot;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      dfs(j, dep + 1);
    }
    outDfs[u] = tot;
    maxDep = Math.max(maxDep, dep);
  }

  boolean isAn(int a, int b) {
    return inDfs[a] < inDfs[b] && outDfs[a] >= outDfs[b];
  }

  class SparseTable {
    int inf = 0x3f3f3f3f;
    int N;
    int logn = 21;
    int[] lg2;

    int[][] dp;

    public SparseTable(int n) {
      this.N = n + 5;
      lg2 = new int[N];
      // dp[i][j] 保留i开始2^j个数中的最大值,logn最大可以a取到lg2(n)
      dp = new int[N][logn];
      initPre();
    }

    public SparseTable(int[] a) {
      this(a.length);
      init(a);
    }

    public SparseTable(List<Integer> list) {
      this(list.size());
      int[] a = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        a[i] = v[list.get(i)];
      }
      init(a);
    }

    // 预处理log函数值
    private void initPre() {
      lg2[0] = -1;
      for (int i = 1; i < N; i++) {
        lg2[i] = lg2[i >> 1] + 1;
      }
    }

    // a下标 [0,n)
    void init(int[] a) {
      int n = a.length;
      for (int i = 0; i < n; i++) {
        dp[i][0] = a[i];
      }
      int t = lg2[n] / lg2[2] + 1;
      for (int j = 1; j < t; j++) {
        for (int i = 0; i + (1 << j) - 1 < n; i++) {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
        }
      }
    }

    // 查询区间[l,r] 从0开始
    int query(int l, int r) {
      if (l > r) {
        return inf;
      }
      int k = lg2[r - l + 1];
      return Math.max(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
  }
}
