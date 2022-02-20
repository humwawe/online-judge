package codeforces.cgr19;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DYetAnotherMinimizationProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      sum += b[i];
    }
    boolean[][] dp = new boolean[n + 1][sum];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < sum; j++) {
        if (dp[i - 1][j]) {
          dp[i][j + a[i - 1]] = true;
          dp[i][j + b[i - 1]] = true;
        }
      }
    }
    int mid = sum / 2;
    int root = 0;
    for (int i = 0; i < sum; i++) {
      if (dp[n][mid + i]) {
        root = mid + i;
        break;
      } else if (dp[n][mid - i]) {
        root = mid - i;
        break;
      }
    }
    int idx = n;
    while (idx > 0) {
      if (root - b[idx - 1] >= 0 && dp[idx - 1][root - b[idx - 1]]) {
        root -= b[idx - 1];
        int t = a[idx - 1];
        a[idx - 1] = b[idx - 1];
        b[idx - 1] = t;
      } else {
        root -= a[idx - 1];
      }
      idx--;
    }
    long s = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        s += (a[j] + a[i]) * (a[j] + a[i]);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        s += (b[j] + b[i]) * (b[j] + b[i]);
      }
    }
    out.println(s);
  }
}
