package codeforces.bye2022;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;
import util.DJSet;

import java.util.Arrays;

public class DKoxiaAndGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = in.nextInt(n);
    boolean[] vis = new boolean[n + 1];
    DJSet djSet = new DJSet(n + 1);

    int[] cnt = new int[n + 1];
    for (int i = 0; i < n; i++) {
      cnt[a[i]]++;
      cnt[b[i]]++;
      djSet.unite(a[i], b[i]);
    }

    int[] cnt1 = new int[n + 1];
    int[] cnt2 = new int[n + 1];
    Arrays.fill(cnt1, 5);
    for (int i = 0; i < n; i++) {
      int root = djSet.root(a[i]);
      if (a[i] != b[i]) {
        cnt1[root] = Math.min(cnt1[root], 2);
      } else {
        cnt1[root] = Math.min(cnt1[root], 1);
        cnt2[root]++;
      }
    }
    int[][] rr = djSet.toBucket();
    long res = 1;
    int mod = 998244353;
    CombinationMath.initMod(mod);
    for (int root = 1; root <= n; root++) {
      if (cnt1[root] == 5) {
        continue;
      }
      int sum = 0;
      for (int i : rr[root]) {
        sum += cnt[i];
        vis[i] = true;
      }
      if (sum != rr[root].length * 2) {
        out.println(0);
        return;
      }
      res = res * CombinationMath.pow(n, cnt2[root]) % mod * cnt1[root] % mod;
    }
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        out.println(0);
        return;
      }
    }

    out.println(res);

  }
}
