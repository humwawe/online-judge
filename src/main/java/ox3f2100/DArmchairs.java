package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DArmchairs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == 1) {
        list1.add(i);
      } else {
        list2.add(i);
      }
    }
    int[][] dp = new int[list1.size() + 1][list2.size() + 1];
    int inf = (int) 1e8;
    for (int i = 1; i < dp.length; i++) {
      Arrays.fill(dp[i], inf);
    }

    for (int i = 1; i <= list1.size(); i++) {
      int p1 = list1.get(i - 1);

      for (int j = i; j <= list2.size(); j++) {
        int p2 = list2.get(j - 1);
        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + Math.abs(p1 - p2));
      }

    }

    out.println(dp[list1.size()][list2.size()]);
  }
}
