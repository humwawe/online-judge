package codeforces.c876;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BLamps {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    List<Integer>[] lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 0; i < n; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt();
      lists[a].add(b);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      lists[i].sort((x, y) -> y - x);
      for (int j = 0; j < Math.min(i + 1, lists[i].size()); j++) {
        res += lists[i].get(j);
      }
    }
    out.println(res);
  }
}
