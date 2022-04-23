package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EYetAnotherBallProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long k = in.nextInt();
    if (k * (k - 1) < n) {
      out.println("NO");
      return;
    }
    out.println("YES");
    int cnt = 0;
    for (int i = 1; i <= k; i++) {
      for (int j = i + 1; j <= k; j++) {
        out.println(i, j);
        cnt++;
        if (cnt == n) {
          return;
        }
        out.println(j, i);
        cnt++;
        if (cnt == n) {
          return;
        }
      }
    }
  }
}
