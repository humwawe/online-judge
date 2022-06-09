package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DMysteriousPresent {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int w = in.nextInt();
    int h = in.nextInt();
    int[][] a = new int[n][3];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
      a[i][2] = i + 1;
    }

    Arrays.sort(a, Comparator.comparingInt(x -> x[0]));
    int[] pre = new int[n];
    int[] dp = new int[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (a[i][0] > w && a[i][1] > h) {
        dp[i] = 1;
        pre[i] = i;
        for (int j = 0; j < i; j++) {
          if (a[i][0] > a[j][0] && a[i][1] > a[j][1]) {
            if (dp[j] + 1 >= dp[i]) {
              dp[i] = dp[j] + 1;
              pre[i] = j;
            }
          }
        }
        res = Math.max(res, dp[i]);
      }
    }
    out.println(res);
    if (res == 0) {
      return;
    }
    int u = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i] == res) {
        u = i;
        break;
      }
    }
    List<Integer> list = new ArrayList<>();
    list.add(a[u][2]);
    while (dp[u] > 1) {
      list.add(a[pre[u]][2]);
      u = pre[u];
    }
    Collections.reverse(list);
    for (Integer integer : list) {
      out.print(integer, "");
    }
  }
}
