package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BInterestingArray {
  int MAXBIT = 30;
  int[] res;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[m][3];
    for (int i = 0; i < m; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
      a[i][2] = in.nextInt();
    }
    int[] sum = new int[n + 2];
    res = new int[n];
    for (int bit = 0; bit <= MAXBIT; bit++) {
      Arrays.fill(sum, 0);

      for (int i = 0; i < m; i++) {
        if (((a[i][2] >> bit) & 1) == 1) {
          sum[a[i][0]]++;
          sum[a[i][1] + 1]--;
        }
      }
      for (int i = 1; i <= n; i++) {
        sum[i] += sum[i - 1];

        if (sum[i] > 0) {
          res[i - 1] |= (1 << bit);
        }
      }
    }
    initPre();
    init(res);
    for (int i = 0; i < m; i++) {
      if (query(a[i][0] - 1, a[i][1] - 1) != a[i][2]) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      out.print(res[i], "");
    }
    out.println();
  }

  int inf = (1 << MAXBIT) - 1;
  int N = (int) (1e5 + 5);
  int logn = 21;
  int[] lg2 = new int[N];
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
        dp[i][j] = dp[i][j - 1] & dp[i + (1 << (j - 1))][j - 1];
      }
    }
  }

  int query(int l, int r) {
    if (l > r) {
      return inf;
    }
    int k = lg2[r - l + 1];
    return dp[l][k] & dp[r - (1 << k) + 1][k];
  }
}
