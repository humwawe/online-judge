package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class AKarenAndGame {
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    int[][] a = new int[n][m];
    int[][] b = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
        b[i][j] = a[i][j];
      }
    }

    List<String> res1 = helper1(a);
    if (res1 == null) {
      out.println("-1");
      return;
    }

    List<String> res2 = helper2(b);
    if (res1.size() <= res2.size()) {
      out.println(res1.size());
      for (String s : res1) {
        out.println(s);
      }
    } else {
      out.println(res2.size());
      for (String s : res2) {
        out.println(s);
      }
    }

  }

  private List<String> helper2(int[][] a) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int min = (int) 1e8;
      for (int j = 0; j < n; j++) {
        min = Math.min(min, a[j][i]);
      }
      for (int j = 0; j < min; j++) {
        res.add("col " + (i + 1));
      }
      for (int j = 0; j < n; j++) {
        a[j][i] -= min;
      }

      for (int j = 0; j < n; j++) {
        int d = a[j][i];
        for (int k = 0; k < d; k++) {
          res.add("row " + (j + 1));
        }
        for (int k = 0; k < m; k++) {
          a[j][k] -= d;
        }
      }
    }

    return res;
  }


  private List<String> helper1(int[][] a) {

    List<String> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int min = (int) 1e8;
      for (int j = 0; j < m; j++) {
        min = Math.min(min, a[i][j]);
      }
      for (int j = 0; j < min; j++) {
        res.add("row " + (i + 1));
      }
      for (int j = 0; j < m; j++) {
        a[i][j] -= min;
      }

      for (int j = 0; j < m; j++) {
        int d = a[i][j];
        for (int k = 0; k < d; k++) {
          res.add("col " + (j + 1));
        }
        for (int k = 0; k < n; k++) {
          a[k][j] -= d;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] != 0) {
          return null;
        }
      }
    }
    return res;
  }
}
