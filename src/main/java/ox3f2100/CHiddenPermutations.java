package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CHiddenPermutations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] res = new int[n];
    Arrays.fill(res, -1);
    for (int i = 0; i < n; i++) {
      if (res[i] == -1) {
        List<Integer> list = new ArrayList<>();
        int x = ask(out, in, i);
        int y = ask(out, in, i);
        list.add(y);
        while (y != x) {
          y = ask(out, in, i);
          list.add(y);
        }
        for (int j = 0; j < list.size(); j++) {
          res[list.get(j)] = list.get((j + 1) % list.size());
        }
      }
    }
    out.print("! ");
    for (int i = 0; i < n; i++) {
      out.print(res[i] + 1);
      out.print(" ");
    }
    out.println();
    out.flush();
  }

  private int ask(OutputWriter out, InputReader in, int i) {
    out.println("?", i + 1);
    out.flush();
    return in.nextInt() - 1;
  }
}
