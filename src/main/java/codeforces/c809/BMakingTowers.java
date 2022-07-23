package codeforces.c809;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BMakingTowers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    List<Integer>[] lists = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      lists[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i++) {
      lists[a[i]].add(i);
    }

    for (int i = 1; i <= n; i++) {
      List<Integer> list = lists[i];

      int[] dp = new int[2];
      int max = 0;
      for (int j = 0; j < list.size(); j++) {
        dp[list.get(j) % 2] = Math.max(dp[1 - list.get(j) % 2] + 1, 1);
        max = Math.max(max, dp[list.get(j) % 2]);
      }
      out.print(max, "");
    }
    out.println();
  }
}
