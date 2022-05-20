package codeforces.c792;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CColumnSwapping {
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }


    int x = check(a);
    if (x == -1) {
      out.println(1, 1);
      return;
    }

    List<Integer> list = new ArrayList<>();
    int[] b = a[x].clone();
    Arrays.sort(b);
    for (int j = 0; j < m; j++) {
      if (a[x][j] != b[j]) {
        list.add(j);
      }
    }

    if (list.size() > 2) {
      out.println(-1);
      return;
    }
    int i1 = list.get(0);
    int i2 = list.get(1);
    
    for (int i = 0; i < n; i++) {
      int t = a[i][i1];
      a[i][i1] = a[i][i2];
      a[i][i2] = t;
    }

    int res = check(a);
    if (res == -1) {
      out.println(i1 + 1, i2 + 1);
    } else {
      out.println(-1);
    }
  }


  private int check(int[][] a) {
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (a[i][j] < a[i][j - 1]) {
          return i;
        }
      }
    }
    return -1;
  }


}
