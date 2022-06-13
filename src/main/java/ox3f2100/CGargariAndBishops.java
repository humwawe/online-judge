package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CGargariAndBishops {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    Map<Integer, Long> map1 = new HashMap<>();
    Map<Integer, Long> map2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
        map1.put(i + j, map1.getOrDefault(i + j, 0L) + a[i][j]);
        map2.put(i - j, map2.getOrDefault(i - j, 0L) + a[i][j]);
      }
    }

    long max1 = -1;
    long max2 = -1;
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if ((i + j) % 2 == 0) {
          if (map1.get(i + j) + map2.get(i - j) - a[i][j] > max1) {
            max1 = map1.get(i + j) + map2.get(i - j) - a[i][j];
            x1 = i;
            y1 = j;
          }
        } else {
          if (map1.get(i + j) + map2.get(i - j) - a[i][j] > max2) {
            max2 = map1.get(i + j) + map2.get(i - j) - a[i][j];
            x2 = i;
            y2 = j;
          }
        }
      }
    }
    out.println(max1 + max2);
    out.println(x1 + 1, y1 + 1, x2 + 1, y2 + 1);

  }
}
