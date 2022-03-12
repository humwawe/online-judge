package codeforces.c777;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CMadokaAndChildishPranks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter() - '0';
      }
    }
    if (a[0][0] == 1) {
      out.println(-1);
      return;
    }
    List<int[]> res = new ArrayList<>();

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {

        if (a[i][j] == 1) {
          if (j == 0) {
            res.add(new int[]{i, j + 1, i + 1, j + 1});
          } else {
            res.add(new int[]{i + 1, j, i + 1, j + 1});
          }
        }
      }
    }
    out.println(res.size());
    for (int[] r : res) {
      out.println(r[0], r[1], r[2], r[3]);
    }
  }
}
