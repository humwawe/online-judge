package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CSlavaAndTanks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 2) {
      out.println("3");
      out.println("2 1 2");
      return;
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i <= n; i += 2) {
      list.add(i);
    }
    for (int i = 1; i <= n; i += 2) {
      list.add(i);
    }
    for (int i = 2; i <= n; i += 2) {
      list.add(i);
    }
    out.println(list.size());
    out.println(list);
  }
}
