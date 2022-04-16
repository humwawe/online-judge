package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class A2BinaryTableHardVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter() - '0';
      }
    }
    List<int[]> res = new ArrayList<>();
    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 1) {
          if (j == m - 1) {
            a[i][j] = 0;
            a[i + 1][j] ^= 1;
            a[i + 1][j - 1] ^= 1;
            res.add(new int[]{i, j, i + 1, j, i + 1, j - 1});
          } else {
            a[i][j] = 0;
            a[i + 1][j] ^= 1;
            a[i + 1][j + 1] ^= 1;
            res.add(new int[]{i, j, i + 1, j, i + 1, j + 1});
          }
        }
      }
    }

    for (int j = 0; j < m - 2; j++) {
      for (int i = n - 2; i < n; i++) {
        if (a[i][j] == 1) {
          a[i][j] = 0;
          a[n - 2][j + 1] ^= 1;
          a[n - 1][j + 1] ^= 1;
          res.add(new int[]{i, j, n - 2, j + 1, n - 1, j + 1});
        }
      }
    }

    List<int[]>[] lists = new List[2];
    lists[0] = new ArrayList<>();
    lists[1] = new ArrayList<>();
    for (int i = n - 2; i < n; i++) {
      for (int j = m - 2; j < m; j++) {
        lists[a[i][j]].add(new int[]{i, j});
      }
    }

    if (lists[1].size() == 1) {
      res.add(new int[]{lists[1].get(0)[0], lists[1].get(0)[1], lists[0].get(0)[0], lists[0].get(0)[1], lists[0].get(1)[0], lists[0].get(1)[1]});
      res.add(new int[]{lists[1].get(0)[0], lists[1].get(0)[1], lists[0].get(1)[0], lists[0].get(1)[1], lists[0].get(2)[0], lists[0].get(2)[1]});
      res.add(new int[]{lists[1].get(0)[0], lists[1].get(0)[1], lists[0].get(2)[0], lists[0].get(2)[1], lists[0].get(0)[0], lists[0].get(0)[1]});
    } else if (lists[1].size() == 2) {
      res.add(new int[]{lists[1].get(0)[0], lists[1].get(0)[1], lists[0].get(0)[0], lists[0].get(0)[1], lists[0].get(1)[0], lists[0].get(1)[1]});
      res.add(new int[]{lists[1].get(1)[0], lists[1].get(1)[1], lists[0].get(0)[0], lists[0].get(0)[1], lists[0].get(1)[0], lists[0].get(1)[1]});
    } else if (lists[1].size() == 3) {
      res.add(new int[]{lists[1].get(0)[0], lists[1].get(0)[1], lists[1].get(1)[0], lists[1].get(1)[1], lists[1].get(2)[0], lists[1].get(2)[1]});
    } else if (lists[1].size() == 4) {
      res.add(new int[]{lists[1].get(0)[0], lists[1].get(0)[1], lists[1].get(1)[0], lists[1].get(1)[1], lists[1].get(2)[0], lists[1].get(2)[1]});
      res.add(new int[]{lists[1].get(1)[0], lists[1].get(1)[1], lists[1].get(2)[0], lists[1].get(2)[1], lists[1].get(3)[0], lists[1].get(3)[1]});
      res.add(new int[]{lists[1].get(2)[0], lists[1].get(2)[1], lists[1].get(3)[0], lists[1].get(3)[1], lists[1].get(0)[0], lists[1].get(0)[1]});
      res.add(new int[]{lists[1].get(3)[0], lists[1].get(3)[1], lists[1].get(0)[0], lists[1].get(0)[1], lists[1].get(1)[0], lists[1].get(1)[1]});
    }
    out.println(res.size());
    for (int[] r : res) {
      for (int i : r) {
        out.print(i + 1, "");
      }
      out.println();
    }
  }
}
