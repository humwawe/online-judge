package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BMarlin {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    char[][] a = new char[4][n];
    for (int i = 0; i < 4; i++) {
      Arrays.fill(a[i], '.');
    }

    if (k % 2 == 0) {
      for (int i = 1; i <= 2; i++) {
        for (int j = 1; j <= k / 2; j++) {
          a[i][j] = '#';
        }
      }

    } else {
      int mid = n / 2;
      int num = k;
      for (int i = 1; i <= 2 && num > 1; i++) {
        for (int j = 1; mid - j >= 1 && num > 1; j++) {
          a[i][mid - j] = a[i][mid + j] = '#';
          num -= 2;
        }
      }
      a[1][mid] = '#';
    }
    out.println("YES");
    for (int i = 0; i < 4; i++) {
      out.println(a[i]);
    }
  }
}
