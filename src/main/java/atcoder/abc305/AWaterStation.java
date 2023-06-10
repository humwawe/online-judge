package atcoder.abc305;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeSet;

public class AWaterStation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i <= 100; i += 5) {
      set.add(i);
    }
    Integer floor = set.floor(n);
    Integer ceiling = set.ceiling(n);

    if (n - floor < ceiling - n) {
      out.println(floor);
    } else {
      out.println(ceiling);
    }

  }
}
