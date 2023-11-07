package ccf.csp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] cnt = new int[1005];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      cnt[x]++;
    }
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < 1005; i++) {
      if (cnt[i] > 0) {
        list.add(new int[]{i, cnt[i]});
      }
    }
    list.sort((x, y) -> {
      if (y[1] == x[1]) {
        return x[1] - y[1];
      }
      return y[1] - x[1];
    });
    for (int[] ints : list) {
      out.println(ints[0], ints[1]);
    }
  }
}
