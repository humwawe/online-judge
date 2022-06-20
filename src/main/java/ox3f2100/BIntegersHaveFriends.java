package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BIntegersHaveFriends {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
    }
    long[] b = new long[n - 1];
    for (int i = 0; i < n - 1; i++) {
      b[i] = Math.abs(a[i + 1] - a[i]);
    }


    SparseTable st = new SparseTable(n);
    st.initPre();
    st.init(b);

    int res = 1;
    int j = -1;
    for (int i = 0; i < n - 1; i++) {
      while (j + 1 < n - 1 && st.query(i, j + 1) > 1) {
        j++;
      }
      res = Math.max(res, j - i + 1 + 1);
    }
    out.println(res);

  }

  class SparseTable {
    int inf = 0x3f3f3f3f;
    int N;
    int logn = 21;
    int[] lg2;
    // dp[i][j] 保留i开始2^j个数中的最大值
    long[][] dp;

    public SparseTable(int n) {
      N = n + 5;
      lg2 = new int[N];
      dp = new long[N][logn];
    }

    // 预处理log函数值
    void initPre() {
      lg2[0] = -1;
      for (int i = 1; i < N; i++) {
        lg2[i] = lg2[i >> 1] + 1;
      }
    }

    // a下标 [0,n)
    void init(long[] a) {
      int n = a.length;
      for (int i = 0; i < n; i++) {
        dp[i][0] = a[i];
      }
      int t = lg2[n] / lg2[2] + 1;
      for (int j = 1; j < t; j++) {
        for (int i = 0; i + (1 << j) - 1 < n; i++) {
          dp[i][j] = gcd(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
        }
      }
    }

    // 查询区间[l,r] 从0开始
    long query(int l, int r) {
      if (l > r) {
        return inf;
      }
      int k = lg2[r - l + 1];
      return gcd(dp[l][k], dp[r - (1 << k) + 1][k]);
    }

    long gcd(long a, long b) {
      return b != 0 ? gcd(b, a % b) : a;
    }
  }
}