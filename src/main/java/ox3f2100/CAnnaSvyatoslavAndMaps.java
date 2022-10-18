package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CAnnaSvyatoslavAndMaps {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int inf = (int) 1e8;
    int[][] dis = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dis[i][j] = in.nextCharacter() - '0';
        if (i != j && dis[i][j] == 0) {
          dis[i][j] = inf;
        }
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
        }
      }
    }
    int m = in.nextInt();
    int[] p = new int[m];
    for (int i = 0; i < m; i++) {
      p[i] = in.nextInt() - 1;
    }
    List<Integer> res = new ArrayList<>();
    res.add(p[0] + 1);
    int last = p[0];
    int cur = 0;
    for (int i = 1; i < m; i++) {
      cur += dis[p[i - 1]][p[i]];
      if (dis[last][p[i]] < cur) {
        last = p[i - 1];
        res.add(last + 1);
        cur = dis[last][p[i]];
      }
    }
    res.add(p[m - 1] + 1);
    out.println(res.size());
    out.println(res);
  }
}
