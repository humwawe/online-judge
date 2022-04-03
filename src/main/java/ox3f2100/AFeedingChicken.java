package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AFeedingChicken {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    char[][] a = new char[n][m];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
        if (a[i][j] == 'R') {
          cnt++;
        }
      }
    }

    int avg = cnt / k;
    int last = cnt % k;

    int need = avg + (last > 0 ? 1 : 0);
    String s = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
    int start = 0;
    int tot = 0;
    char[][] res = new char[n][m];
    int c = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int x = i;
        int y = j;
        if (i % 2 != 0) {
          y = m - 1 - j;
        }
        res[x][y] = s.charAt(start);
        if (need == 0) {
          continue;
        }
        if (a[x][y] == 'R') {
          tot++;
          c++;
        }
        if (c == need) {
          last--;
          need = avg + (last > 0 ? 1 : 0);
          c = 0;
          if (tot != cnt) {
            start++;
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      out.println(res[i]);
    }
  }
}
