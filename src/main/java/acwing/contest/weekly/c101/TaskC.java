package acwing.contest.weekly.c101;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    STMAX stmax = new STMAX(a);
    STMIN stmin = new STMIN(a);
    int res = 1;
    for (int i = 0; i < n; i++) {
      int l = 0;
      int r = i;
      while (l < r) {
        int mid = l + r >> 1;
        int max = stmax.query(mid, i);
        int min = stmin.query(mid, i);
        if (max - min <= 1) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      res = Math.max(res, i - l + 1);
    }
    out.println(res);
  }


  class STMAX {
    int N;
    int logn = 21;
    int[] lg2;

    int[][] dp;

    public STMAX(int n) {
      this.N = n + 5;
      lg2 = new int[N];
      // dp[i][j] 保留i开始2^j个数中的最大值,logn最大可以a取到lg2(n)
      dp = new int[N][logn];
      initPre();
    }

    public STMAX(int[] a) {
      this(a.length);
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
      int k = lg2[r - l + 1];
      return Math.max(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
  }

  class STMIN {
    int N;
    int logn = 21;
    int[] lg2;

    int[][] dp;

    public STMIN(int n) {
      this.N = n + 5;
      lg2 = new int[N];
      // dp[i][j] 保留i开始2^j个数中的最大值,logn最大可以a取到lg2(n)
      dp = new int[N][logn];
      initPre();
    }

    public STMIN(int[] a) {
      this(a.length);
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
          dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
        }
      }
    }

    // 查询区间[l,r] 从0开始
    int query(int l, int r) {
      int k = lg2[r - l + 1];
      return Math.min(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
  }
}