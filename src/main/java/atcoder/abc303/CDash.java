package atcoder.abc303;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class CDash {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int h = in.nextInt();
    int k = in.nextInt();
    String s = in.nextString();
    long base = (long) 1e6;
    Set<Long> set = new HashSet<>();
    int[][] items = new int[m][2];
    for (int i = 0; i < m; i++) {
      items[i][0] = in.nextInt();
      items[i][1] = in.nextInt();
      set.add(items[i][0] * base + items[i][1]);
    }

    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      h--;

      if (s.charAt(i) == 'R') {
        x++;
      } else if (s.charAt(i) == 'L') {
        x--;
      } else if (s.charAt(i) == 'U') {
        y++;
      } else {
        y--;
      }

      if (h < 0) {
        out.println("No");
        return;
      }

      if (set.contains(x * base + y) && h < k) {
        h = k;
        set.remove(x * base + y);
      }
    }
    out.println("Yes");
  }
}
