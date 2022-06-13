package codeforces.e130;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AParkwayWalk {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      sum += x;
    }
    out.println(Math.max(0, sum - m));
  }
}
