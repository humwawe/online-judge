package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Deque;

public class BLabyrinth {
  int r, c;
  char[][] a;
  int[][] fs = new int[][]{{1, 0, 0, 0}, {-1, 0, 0, 0}, {0, 1, 0, 1}, {0, -1, 1, 0}};
  int x, y;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    r = in.nextInt() - 1;
    c = in.nextInt() - 1;
    x = in.nextInt();
    y = in.nextInt();
    a = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }

    Deque<int[]> deque = new ArrayDeque<>();
    deque.add(new int[]{r, c, 0, 0});
    a[r][c] = 'X';
    int res = 1;
    while (!deque.isEmpty()) {
      int[] cur = deque.pollFirst();

      for (int[] f : fs) {
        int ni = cur[0] + f[0];
        int nj = cur[1] + f[1];
        int ncx = cur[2] + f[2];
        int ncy = cur[3] + f[3];
        if (ni >= 0 && ni < n && nj >= 0 && nj < m && a[ni][nj] == '.' && ncx <= x && ncy <= y) {
          a[ni][nj] = 'X';
          res++;
          if (f[2] == 0 && f[3] == 0) {
            deque.addFirst(new int[]{ni, nj, ncx, ncy});
          } else {
            deque.addLast(new int[]{ni, nj, ncx, ncy});
          }

        }
      }
    }
    out.println(res);
  }

}
