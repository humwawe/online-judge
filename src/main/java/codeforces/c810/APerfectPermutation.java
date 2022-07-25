package codeforces.c810;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APerfectPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 1; i <= n - 1; i++) {
      out.print(i + 1, "");
    }
    out.println(1);
  }
}
