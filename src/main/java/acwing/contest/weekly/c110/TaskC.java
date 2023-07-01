package acwing.contest.weekly.c110;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int n = in.nextInt();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    Arrays.sort(a, Comparator.comparingInt(x -> x[1]));
    int mod = (int) 1e9 + 7;
    int[] dp = new int[n + 1];

    dp[0] = 1;
    List<Integer> list = new ArrayList<>();
    List<Integer> sum = new ArrayList<>();
    list.add(0);
    sum.add(0);
    sum.add(1);

    for (int i = 1; i <= n; i++) {
      int l = a[i - 1][0];
      int r = a[i - 1][1] - 1;

      int le = 0;
      int ri = list.size() - 1;

      while (le < ri) {
        int mid = le + ri >> 1;
        if (list.get(mid) >= l) {
          ri = mid;
        } else {
          le = mid + 1;
        }
      }
      int x = le;

      le = 0;
      ri = list.size() - 1;

      while (le < ri) {
        int mid = le + ri + 1 >> 1;
        if (list.get(mid) <= r) {
          le = mid;
        } else {
          ri = mid - 1;
        }
      }
      int y = le;

      if (list.get(x) >= l) {
        dp[i] = (sum.get(y + 1) - sum.get(x) + mod) % mod;
      }


      list.add(a[i - 1][1]);
      sum.add((sum.get(sum.size() - 1) + dp[i]) % mod);
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (a[i][1] == m) {
        res += dp[i + 1];
        res %= mod;
      }
    }
    out.println(res);
  }
}
