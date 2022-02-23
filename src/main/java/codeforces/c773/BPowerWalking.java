package codeforces.c773;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class BPowerWalking {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      set.add(t);
    }
    int size = set.size();
    for (int i = 1; i <= n; i++) {
      out.print(Math.max(size, i), "");
    }
    out.println();
  }
}
