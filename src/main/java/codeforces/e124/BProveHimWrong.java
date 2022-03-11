package codeforces.e124;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BProveHimWrong {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    List<Integer> list = new ArrayList<>();
    int t = 1;
    for (int i = 0; i < n; i++) {
      if (t > 1e9) {
        out.println("NO");
        return;
      }
      list.add(t);
      t *= 3;
    }
    out.println("YES");
    for (Integer i : list) {
      out.print(i, "");
    }
    out.println();
  }
}
