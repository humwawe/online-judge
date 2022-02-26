package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CLeagueOfLeesins {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] deg = new int[n + 1];
    List<Integer>[] lists = new List[n + 1];
    for (int i = 0; i <= n; i++) {
      lists[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 2; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      deg[a]++;
      deg[b]++;
      deg[c]++;
      lists[a].add(b);
      lists[a].add(c);
      lists[b].add(a);
      lists[b].add(c);
      lists[c].add(a);
      lists[c].add(b);
    }
    int x = 0;
    int y = 0;
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 1) {
        x = i;
        if (deg[lists[i].get(0)] == 2) {
          y = lists[i].get(0);
        } else {
          y = lists[i].get(1);
        }
      }
    }
    boolean[] vis = new boolean[n + 1];
    out.print(x, y);
    vis[x] = true;
    vis[y] = true;
    int z = 0;
    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < lists[x].size(); j++) {
        if (!vis[lists[x].get(j)]) {
          z = lists[x].get(j);
        }
      }
      vis[z] = true;
      out.print("", z);
      x = y;
      y = z;
    }
    out.println();
  }
}
