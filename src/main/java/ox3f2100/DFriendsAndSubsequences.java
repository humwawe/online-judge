package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DFriendsAndSubsequences {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    SparseTable stMax = new SparseTable(true);
    stMax.initPre();
    stMax.init(a);

    SparseTable stMin = new SparseTable(false);
    stMin.initPre();
    stMin.init(b);

    long res = 0;

    for (int i = 0; i < n; i++) {
      int l = 0;
      int r = i;
      while (l < r) {
        int mid = l + r >> 1;
        int t1 = stMax.query(mid, i);
        int t2 = stMin.query(mid, i);
        if (t1 > t2) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }

      int x = l;

      l = 0;
      r = i;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        int t1 = stMax.query(mid, i);
        int t2 = stMin.query(mid, i);
        if (t1 >= t2) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      int y = l;

      if (stMax.query(x, i) == stMin.query(x, i)) {
        res += y - x + 1;
      }
    }
    out.println(res);

  }

  class SparseTable {
    int inf = 0x3f3f3f3f;
    int N = (int) (2e5 + 5);
    int logn = 21;
    int[] lg2 = new int[N];
    // dp[i][j] 保留i开始2^j个数中的最大值
    int[][] dp = new int[N][logn];
    boolean max = true;

    public SparseTable(boolean max) {
      this.max = max;
    }

    // 预处理log函数值
    void initPre() {
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
      if (max) {
        for (int j = 1; j < t; j++) {
          for (int i = 0; i + (1 << j) - 1 < n; i++) {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
          }
        }
      } else {
        for (int j = 1; j < t; j++) {
          for (int i = 0; i + (1 << j) - 1 < n; i++) {
            dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
          }
        }
      }

    }

    // 查询区间[l,r] 从0开始
    int query(int l, int r) {
      if (l > r) {
        return inf;
      }
      int k = lg2[r - l + 1];
      if (max) {
        return Math.max(dp[l][k], dp[r - (1 << k) + 1][k]);
      } else {
        return Math.min(dp[l][k], dp[r - (1 << k) + 1][k]);
      }

    }
  }
}
