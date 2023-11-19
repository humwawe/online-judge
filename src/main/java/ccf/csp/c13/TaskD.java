package ccf.csp.c13;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskD {
  int n = 3;

  Map<String, Integer> memo = new HashMap<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[][] a = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    if (check(a, 1)) {
      out.println(cnt0(a) + 1);
      return;
    }
    if (check(a, 2)) {
      out.println(-cnt0(a) - 1);
      return;
    }

    out.println(dfs(a, 1));

  }

  private int dfs(int[][] a, int turn) {
    if (check(a, 1)) {
      return cnt0(a) + 1;
    }
    if (check(a, 2)) {
      return -cnt0(a) - 1;
    }
    if (cnt0(a) == 0) {
      return 0;
    }

    String key = helper(a) + turn;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    int res;
    if (turn == 1) {
      res = -100;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (a[i][j] == 0) {
            a[i][j] = 1;
            res = Math.max(res, dfs(a, 3 - turn));
            a[i][j] = 0;
          }
        }
      }
    } else {
      res = 100;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (a[i][j] == 0) {
            a[i][j] = 2;
            res = Math.min(res, dfs(a, 3 - turn));
            a[i][j] = 0;
          }
        }
      }
    }
    memo.put(key, res);
    return res;
  }

  private String helper(int[][] a) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(a[i][j]);
      }
    }
    return sb.toString();
  }


  private int cnt0(int[][] a) {
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 0) {
          res++;
        }
      }
    }
    return res;
  }

  private boolean check(int[][] a, int x) {
    for (int i = 0; i < n; i++) {
      int s = 0;
      for (int j = 0; j < n; j++) {
        if (a[i][j] == x) {
          s++;
        }
      }
      if (s == n) {
        return true;
      }
    }

    for (int i = 0; i < n; i++) {
      int s = 0;
      for (int j = 0; j < n; j++) {
        if (a[j][i] == x) {
          s++;
        }
      }
      if (s == n) {
        return true;
      }
    }
    int s = 0;
    for (int i = 0; i < n; i++) {
      if (a[i][i] == x) {
        s++;
      }
    }
    if (s == n) {
      return true;
    }
    s = 0;
    for (int i = 0; i < n; i++) {
      if (a[i][n - i - 1] == x) {
        s++;
      }
    }
    if (s == n) {
      return true;
    }

    return false;
  }
}
