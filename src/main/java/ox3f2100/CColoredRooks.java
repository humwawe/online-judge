package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CColoredRooks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<Integer>[] lists = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      lists[i] = new ArrayList<>();
      lists[i].add(i);
    }
    int cnt = n + 1;
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      lists[a].add(cnt);
      lists[b].add(cnt);
      cnt++;
    }
    for (int i = 1; i <= n; i++) {
      out.println(lists[i].size());
      for (Integer j : lists[i]) {
        out.println(i, j);
      }
    }
  }
}
