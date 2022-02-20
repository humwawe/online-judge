package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DWalkOnMatrix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();
    if (k == 0) {
      out.println("1 1");
      out.println("1");
      return;
    }
    int[][] a = new int[3][3];
    int x = Integer.highestOneBit(k) * 2 - 1;
    int y = Integer.highestOneBit(k) * 4 - 1;
    a[0][0] = y;
    a[0][1] = x;
    a[1][0] = x + 1;
    a[1][1] = x;
    a[1][2] = x - k;
    a[2][0] = y;
    a[2][1] = y;
    a[2][2] = x;
    out.println("3 3");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        out.print(a[i][j] + " ");
      }
      out.println();
    }

  }
}
