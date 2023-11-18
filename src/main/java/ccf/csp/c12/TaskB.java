package ccf.csp.c12;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 1; i <= n; i++) {
      set.add(i);
    }
    int cur = 1;
    while (set.size() > 1) {
      List<Integer> rem = new ArrayList<>();
      for (Integer i : set) {
        if (cur % k == 0 || cur % 10 == k) {
          rem.add(i);
        }
        cur++;
      }
      set.removeAll(rem);
      if (set.size() == 0) {
        out.println(rem.get(rem.size() - 1));
        return;
      }
    }
    out.println(set.first());
  }
}
