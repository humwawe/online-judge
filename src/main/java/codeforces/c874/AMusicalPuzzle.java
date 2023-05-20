package codeforces.c874;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class AMusicalPuzzle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n - 1; i++) {
      set.add(s.substring(i, i + 2));
    }
    out.println(set.size());
  }
}
