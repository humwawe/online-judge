package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BUnmerge {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n * 2];
    for (int i = 0; i < 2 * n; i++) {
      a[i] = in.nextInt();
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 2 * n; i++) {
      int j = i;
      while (j + 1 < 2 * n && a[j + 1] < a[i]) {
        j++;
      }
      list.add(j - i + 1);
      i = j;
    }

    boolean[][] dp = new boolean[list.size() + 1][2 * n + 1];

    dp[0][0] = true;

    for (int i = 1; i <= list.size(); i++) {
      int v = list.get(i - 1);
      for (int j = 0; j <= n; j++) {
        dp[i][j] |= dp[i - 1][j];
        if (j + v <= 2 * n) {
          dp[i][j + v] |= dp[i - 1][j];
        }
      }
    }
    if (dp[list.size()][n]) {
      out.println("YES");
    } else {
      out.println("NO");
    }

  }
}
