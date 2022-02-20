package acwing.contest.weekly.c27;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskC {
  Node[] a;
  int n, k;
  int inf = (int) 1e8;
  Map<String, Integer> memo = new HashMap<>();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    a = new Node[n];
    for (int i = 0; i < n; i++) {
      long num = in.nextLong();
      a[i] = helper(num);
    }
    int[][] f = new int[k + 1][26 * 200];
    for (int i = 0; i < k + 1; i++) {
      Arrays.fill(f[i], -inf);
    }
    f[0][0] = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = k; j > 0; --j) {
        for (int k = 25 * n; k >= a[i].c5; --k) {
          f[j][k] = Math.max(f[j][k], f[j - 1][k - a[i].c5] + a[i].c2);
        }
      }
    }
    int res = 0;
    for (int i = 1; i < 26 * n; ++i) {
      res = Math.max(res, Math.min(i, f[k][i]));
    }
    out.println(res);
    //        out.println(dfs(0, 0, 0));
    //        out.println(dfs2(0, 0, 0, 0));
  }

  //    private int dfs2(int i, int cnt, int c2, int c5) {
  //        String key = i + "|" + cnt + "|" + c2 + "|" + c5;
  //        if (memo.containsKey(key)) {
  //            return memo.get(key);
  //        }
  //        if (cnt == k) {
  //            return Math.min(c2, c5);
  //        }
  //        if (i == n) {
  //            return -inf;
  //        }
  //
  //        int res = 0;
  //        res = Math.max(res, dfs2(i + 1, cnt + 1, c2 + a[i].c2, c5 + a[i].c5) + a[i].c0);
  //        res = Math.max(res, dfs2(i + 1, cnt, c2, c5));
  //        memo.put(key, res);
  //        return res;
  //    }

  private int dfs(int i, int cnt, int diff) {
    if (diff > 5000) {
      return dfs(i, cnt, 5000);
    }
    String key = i + "|" + cnt + "|" + diff;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    if (cnt == k) {
      memo.put(key, 0);
      return 0;
    }
    if (i == n) {
      memo.put(key, -inf);
      return -inf;
    }
    int res = 0;
    res = Math.max(res, dfs(i + 1, cnt, diff));
    int tmp = a[i].c2 - a[i].c5;
    if (tmp * diff >= 0) {
      res = Math.max(res, dfs(i + 1, cnt + 1, diff + tmp) + a[i].c0);
    } else {
      res = Math.max(res, dfs(i + 1, cnt + 1, diff + tmp) + a[i].c0 + Math.min(Math.abs(diff), Math.abs(tmp)));
    }
    memo.put(key, res);
    return res;
  }

  private Node helper(long num) {
    int c0 = 0;
    int c2 = 0;
    int c5 = 0;
    //        while (num > 0 && num % 10 == 0) {
    //            c0++;
    //            num /= 10;
    //        }
    while (num > 0 && num % 5 == 0) {
      c5++;
      num /= 5;
    }
    while (num > 0 && num % 2 == 0) {
      c2++;
      num /= 2;
    }

    return new Node(c0, c2, c5);
  }

  class Node {
    int c0;
    int c2;
    int c5;

    public Node(int c0, int c2, int c5) {
      this.c0 = c0;
      this.c2 = c2;
      this.c5 = c5;
    }
  }
}
