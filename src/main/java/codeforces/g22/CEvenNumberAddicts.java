package codeforces.g22;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CEvenNumberAddicts {
  Boolean[][][][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (a % 2 == 0) {
        cnt1++;
      } else {
        cnt2++;
      }
    }
    memo = new Boolean[cnt1 + 1][cnt2 + 1][2][2];

    boolean res = dfs(cnt1, cnt2, 0, 0);
    if (res) {
      out.println("Alice");
    } else {
      out.println("Bob");
    }
  }

  private boolean dfs(int cnt1, int cnt2, int i, int t) {
    if (cnt1 == 0 && cnt2 == 0) {
      return i % 2 == 0;
    }
    if (memo[cnt1][cnt2][i][t] != null) {
      return memo[cnt1][cnt2][i][t];
    }
    if (t == 0) {
      if (cnt1 >= 1) {
        if (dfs(cnt1 - 1, cnt2, i, 1 - t)) {
          return memo[cnt1][cnt2][i][t] = true;
        }
      }
      if (cnt2 >= 1) {
        if (dfs(cnt1, cnt2 - 1, 1 - i, 1 - t)) {
          return memo[cnt1][cnt2][i][t] = true;
        }
      }
      return memo[cnt1][cnt2][i][t] = false;
    } else {
      if (cnt1 >= 1) {
        if (!dfs(cnt1 - 1, cnt2, i, 1 - t)) {
          return memo[cnt1][cnt2][i][t] = false;
        }
      }
      if (cnt2 >= 1) {
        if (!dfs(cnt1, cnt2 - 1, i, 1 - t)) {
          return memo[cnt1][cnt2][i][t] = false;
        }
      }
      return memo[cnt1][cnt2][i][t] = true;
    }
  }


}
