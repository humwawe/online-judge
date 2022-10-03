package codeforces.c824;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AWorkingWeek {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = 2;
    int y = (n + 5 + 2) / 3;
    int z = n;
    int l1 = x - 1;
    int l2 = y - x - 1;
    int l3 = z - y - 1;
    out.println(Math.min(Math.min(Math.abs(l1 - l2), Math.abs(l2 - l3)), Math.abs(l3 - l1)));
  }
}
