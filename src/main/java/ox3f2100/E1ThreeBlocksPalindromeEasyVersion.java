package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class E1ThreeBlocksPalindromeEasyVersion {
  int N = 26;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int[][] sum = new int[n + 1][N + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= N; j++) {
        sum[i + 1][j] = sum[i][j];
      }
      sum[i + 1][a[i]]++;
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int mid = 0;
        int max = 0;
        for (int k = 1; k <= N; k++) {
          max = Math.max(max, Math.min(sum[i][k], sum[n][k] - sum[j + 1][k]));
          mid = Math.max(mid, sum[j + 1][k] - sum[i][k]);
        }
        res = Math.max(res, max * 2 + mid);
      }
    }
    out.println(res);
  }
}
