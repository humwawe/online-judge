package acwing.contest.weekly.c39;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.nextInt();
    String[] l = new String[q];
    String[] r = new String[q];
    for (int i = 0; i < q; i++) {
      l[i] = in.nextString();
      r[i] = in.nextString();
    }
    boolean[] vis = new boolean[q];
    List<String[]> res = new ArrayList<>();
    for (int i = 0; i < q; i++) {
      if (vis[i]) {
        continue;
      }
      vis[i] = true;
      String t = r[i];
      for (int j = i + 1; j < q; j++) {
        if (vis[j]) {
          continue;
        }
        if (l[j].equals(t)) {
          t = r[j];
          vis[j] = true;
        }
      }
      res.add(new String[]{l[i], t});
    }
    out.println(res.size());
    for (String[] s : res) {
      out.println(s[0], s[1]);
    }
  }
}
