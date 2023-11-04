package ccf.csp.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(in.nextInt());
    }

    int res = 0;
    for (Integer i : set) {
      if (set.contains(-i)) {
        res++;
      }
    }
    out.println(res / 2);
  }
}
