package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CFourSegments {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[][] a = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        a[i][j] = in.nextInt();
      }
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < 4; i++) {
      String k = "" + a[i][0] + a[i][1];
      map.put(k, map.getOrDefault(k, 0) + 1);
      k = "" + a[i][2] + a[i][3];
      map.put(k, map.getOrDefault(k, 0) + 1);
    }
    for (Integer value : map.values()) {
      if (value != 2) {
        out.println("NO");
        return;
      }
    }
    int x = 0;
    int y = 0;
    for (int i = 0; i < 4; i++) {
      if (a[i][0] == a[i][2] && a[i][1] != a[i][3]) {
        y++;
      }
      if (a[i][1] == a[i][3] && a[i][0] != a[i][2]) {
        x++;
      }
    }
    if (x == 2 && y == 2) {
      out.println("YES");
    } else {
      out.println("NO");
    }

  }

}
