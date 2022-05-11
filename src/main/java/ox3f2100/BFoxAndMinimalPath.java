package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BFoxAndMinimalPath {
  int k;
  char[][] res = new char[100][100];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (int i = 0; i < 100; i++) {
      Arrays.fill(res[i], 'N');
    }
    k = in.nextInt();
    int x = 3;
    int y = 4;
    int z = 5;
    add(0, 3);
    add(0, 4);
    while (k > 0) {
      add(x, x + 3);
      add(x, y + 3);
      add(y, y + 3);
      add(y, x + 3);
      add(z, z + 3);
      if ((k & 1) == 1) {
        add(y, z);
      }
      k >>= 1;
      x += 3;
      y += 3;
      z += 3;
    }
    add(1, z);
    out.println(100);
    for (int i = 0; i < 100; i++) {
      //      for (int j = 0; j < 100; j++) {
      //        out.print(res[i][j]);
      //      }
      out.println(res[i]);
    }

  }

  private void add(int a, int b) {
    res[a][b] = 'Y';
    res[b][a] = 'Y';
  }
}
