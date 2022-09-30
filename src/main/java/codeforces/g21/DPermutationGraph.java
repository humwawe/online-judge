package codeforces.g21;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DPermutationGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }


    SparseTable stMax = new SparseTable(n, true);
    stMax.initPre();
    stMax.init(a);

    SparseTable stMin = new SparseTable(n, false);
    stMin.initPre();
    stMin.init(a);
    int res = 0;
    for (int i = 0; i < n - 1; res++) {
      if (a[i + 1] > a[i]) {
        int l = i + 1;
        int r = n - 1;
        while (l < r) {
          int mid = l + r + 1 >> 1;
          if (stMin.query(l, mid) < a[i]) {
            r = mid - 1;
          } else {
            l = mid;
          }
        }
        l = i + 1;
        while (l < r) {
          int mid = l + r >> 1;
          if (stMax.query(l, mid) > stMax.query(mid + 1, r)) {
            r = mid;
          } else {
            l = mid + 1;
          }
        }

        i = l;
      } else {
        int l = i + 1;
        int r = n - 1;
        while (l < r) {
          int mid = l + r + 1 >> 1;
          if (stMax.query(l, mid) > a[i]) {
            r = mid - 1;
          } else {
            l = mid;
          }
        }
        l = i + 1;
        while (l < r) {
          int mid = l + r >> 1;
          if (stMin.query(l, mid) < stMin.query(mid + 1, r)) {
            r = mid;
          } else {
            l = mid + 1;
          }
        }

        i = l;
      }

    }
    out.println(res);


  }


  class SparseTable {
    int inf = 0x3f3f3f3f;
    int N;
    int logn = 21;
    int[] lg2;
    int[][] dp;
    boolean max;

    public SparseTable(int n, boolean max) {
      N = n + 5;
      lg2 = new int[N];
      dp = new int[N][logn];
      this.max = max;
    }

    void initPre() {
      lg2[0] = -1;
      for (int i = 1; i < N; i++) {
        lg2[i] = lg2[i >> 1] + 1;
      }
    }

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

    int query(int l, int r) {
      if (l > r) {
        if (max) {
          return -inf;
        } else {
          return inf;
        }

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
