package codeforces.cgr21;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ANITOrz {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int z = in.nextInt();
    int max = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      max = Math.max(max, x | z);
    }
    out.println(max);
  }
}
