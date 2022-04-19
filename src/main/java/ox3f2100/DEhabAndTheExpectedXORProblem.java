package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DEhabAndTheExpectedXORProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    List<Integer> b = new ArrayList<>();
    b.add(0);
    Set<Integer> set = new HashSet<>();
    set.add(0);
    for (int i = 1; i < Math.pow(2, n); i++) {
      if (set.contains(i ^ x)) {
        continue;
      }
      b.add(i);
      set.add(i);
    }
    out.println(b.size() - 1);
    for (int i = 1; i < b.size(); i++) {
      out.print((b.get(i) ^ b.get(i - 1)) + " ");
    }
    out.println();
  }
}
