package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class CIvanAndPowersOfTwo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int max = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      while (set.contains(x)) {
        set.remove(x);
        x++;
      }
      set.add(x);
      max = Math.max(max, x);
    }
    out.println(max - set.size() + 1);
  }
}
