package leetcode.c352;

/**
 * @author hum
 */
public class C3 {

  public long continuousSubarrays(int[] nums) {
    int n = nums.length;
    int j = 0;
    STMAX stmax = new STMAX(nums);
    STMIN stmin = new STMIN(nums);
    long res = 0;
    for (int i = 0; i < n; i++) {
      int l = 0;
      int r = i;
      while (l < r) {
        int mid = l + r >> 1;
        int max = stmax.query(mid, i);
        int min = stmin.query(mid, i);
        if (max - min <= 2) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      int len = i - l + 1;
      res += len;
    }
    return res;
  }

  class STMAX {
    int inf = 0x3f3f3f3f;
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
      if (l > r) {
        return inf;
      }
      int k = lg2[r - l + 1];
      return Math.max(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
  }

  class STMIN {
    int inf = 0x3f3f3f3f;
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
      if (l > r) {
        return inf;
      }
      int k = lg2[r - l + 1];
      return Math.min(dp[l][k], dp[r - (1 << k) + 1][k]);
    }
  }
}
