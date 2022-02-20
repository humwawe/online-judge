package codeforces.c754;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CDominantCharacter {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    String s = in.nextString();
    int[][] sum = new int[n + 1][3];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 3; j++) {
        sum[i][j] = sum[i - 1][j];
      }
      sum[i][s.charAt(i - 1) - 'a']++;
    }

    for (int i = 2; i < 20; i++) {
      if (check(i, sum)) {
        out.println(i);
        return;
      }
    }
    out.println(-1);
  }

  private boolean check(int len, int[][] sum) {
    for (int j = len; j <= n; j++) {
      int a = sum[j][0] - sum[j - len][0];
      int b = sum[j][1] - sum[j - len][1];
      int c = sum[j][2] - sum[j - len][2];
      if (a > b && a > c) {
        return true;
      }
    }
    return false;
  }
}
