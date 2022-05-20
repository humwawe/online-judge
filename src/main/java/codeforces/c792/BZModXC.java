package codeforces.c792;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BZModXC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    out.println(a + b + c, b + c, c);
  }
}
