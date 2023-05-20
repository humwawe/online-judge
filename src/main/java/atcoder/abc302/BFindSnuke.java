package atcoder.abc302;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BFindSnuke {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    String tmp = "snuke";
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 's') {
          for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
              if (k == 0 && l == 0) {
                continue;
              }
              int x = i;
              int y = j;
              int cnt = 1;
              while (cnt < 5) {
                x += k;
                y += l;
                if (x >= 0 && x < n && y >= 0 && y < m) {
                  if (a[x][y] != tmp.charAt(cnt)) {
                    break;
                  }
                } else {
                  break;
                }
                cnt++;
              }
              if (cnt == 5) {
                for (int o = 0; o < 5; o++) {
                  out.println(i + o * k + 1, j + o * l + 1);
                }
                return;
              }

            }
          }
        }
      }
    }
  }
}
