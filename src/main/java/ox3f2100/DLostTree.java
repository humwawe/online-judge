package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DLostTree {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.println("? 1");
    out.flush();
    List<int[]> res = new ArrayList<>();
    List<Integer>[] list = new List[2];
    for (int i = 0; i < 2; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 1; i <= n; i++) {
      int a = in.nextInt();
      if (a == 1) {
        res.add(new int[]{1, i});
      }
      if (a != 0) {
        list[a % 2].add(i);
      }
    }
    int k = 0;
    if (list[1].size() < list[0].size()) {
      k = 1;
    }

    for (Integer integer : list[k]) {
      out.println("? " + integer);
      out.flush();
      for (int i = 1; i <= n; i++) {
        int a = in.nextInt();
        if (i != 1 && a == 1) {
          res.add(new int[]{integer, i});
        }
      }
    }
    out.println("!");
    for (int[] e : res) {
      out.println(e[0], e[1]);
    }
  }
}
