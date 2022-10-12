package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DRorororobot {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt();
    }
    SparseTable st = new SparseTable();
    st.initPre();
    st.init(a);
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      long x1 = in.nextInt();
      int y1 = in.nextInt();
      long x2 = in.nextInt();
      int y2 = in.nextInt();
      int k = in.nextInt();
      if (y1 > y2) {
        long tx = x1;
        x1 = x2;
        x2 = tx;
        int ty = y1;
        y1 = y2;
        y2 = ty;
      }
      if ((y1 - y2) % k != 0) {
        out.println("NO");
        continue;
      }

      long max = st.query(y1 - 1, y2 - 1);
      long s = x1;
      if (x1 <= max) {
        long d = max - x1 + 1;
        s = x1 + (d + k - 1) / k * k;
        if (s > n) {
          out.println("NO");
          continue;
        }
      }
      if (Math.abs(s - x2) % k != 0) {
        out.println("NO");
        continue;
      }
      out.println("YES");
    }
  }

  class SparseTable {
    int inf = 0x3f3f3f3f;
    int N = (int) (2e5 + 5);
    int logn = 21;
    int[] lg2 = new int[N];
    // dp[i][j] 保留i开始2^j个数中的最大值
    int[][] dp = new int[N][logn];

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