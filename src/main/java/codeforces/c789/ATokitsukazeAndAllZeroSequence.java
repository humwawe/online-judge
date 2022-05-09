package codeforces.c789;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class ATokitsukazeAndAllZeroSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Set<Integer> set = new HashSet<>();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == 0) {
        cnt++;
      }
      set.add(a[i]);
    }

    if (cnt > 0) {
      out.println(n - cnt);
      return;
    }

    if (set.size() != n) {
      out.println(n);
      return;
    }

    out.println(n + 1);

  }
}
