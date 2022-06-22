package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DJourney {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt() + 1;
    String s = in.nextString();

    int[] l = new int[n];
    int[] r = new int[n];

    int[][] dp1 = new int[n + 1][2];
    int[][] dp2 = new int[n + 1][2];

    for (int i = 1; i < n; i++) {
      if (s.charAt(i - 1) == 'L') {
        dp1[i][0] = dp1[i - 1][1] + 1;
        dp1[i][1] = 0;
        l[i] = dp1[i][0];
      } else {
        dp1[i][1] = dp1[i - 1][0] + 1;
        dp1[i][0] = 0;
      }
    }


    for (int i = n - 2; i >= 0; i--) {
      if (s.charAt(i) == 'R') {
        dp2[i][0] = dp2[i + 1][1] + 1;
        dp2[i][1] = 0;
        r[i] = dp2[i][0];
      } else {
        dp2[i][1] = dp2[i + 1][0] + 1;
        dp2[i][0] = 0;
      }
    }

    for (int i = 0; i < n; i++) {
      out.print(l[i] + r[i] + 1, "");
    }
    out.println();

  }
}
