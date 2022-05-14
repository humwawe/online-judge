package codeforces.e128;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BRobots {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char x = in.nextCharacter();
        if (x == 'R') {
          list.add(new int[]{i, j});
        }
      }
    }
    f:
    for (int i = 0; i < list.size(); i++) {
      int c1 = list.get(i)[0];
      int c2 = list.get(i)[1];
      for (int j = 0; j < list.size(); j++) {
        if (i == j) {
          continue;
        }
        int x = list.get(j)[0] - c1;
        int y = list.get(j)[1] - c2;
        if (x < 0 || x >= n || y < 0 || y >= m) {
          continue f;
        }
      }
      out.println("YES");
      return;
    }
    out.println("NO");

  }
}
