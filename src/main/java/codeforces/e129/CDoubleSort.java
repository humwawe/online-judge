package codeforces.e129;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CDoubleSort {

  List<int[]> res = new ArrayList<>();


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    res.clear();

    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          swap(b, j, j + 1);
          res.add(new int[]{j, j + 1});
        }
      }
    }

    for (int i = 0; i < n; i++) {
      int j = i;
      while (j + 1 < n && a[j + 1] == a[i]) {
        j++;
      }

      helper(b, i, j);

      i = j;
    }


    for (int i = 0; i < n - 1; i++) {
      if (b[i] > b[i + 1]) {
        out.println(-1);
        return;
      }
    }
    out.println(res.size());

    for (int[] re : res) {
      out.println(re[0] + 1, re[1] + 1);
    }

  }

  private void helper(int[] b, int pi, int pj) {
    for (int i = pi; i < pj; i++) {
      for (int j = pi; j + 1 <= pj - (i - pi); j++) {
        if (b[j] > b[j + 1]) {
          swap(b, j, j + 1);
          res.add(new int[]{j, j + 1});
        }
      }
    }

  }

  private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }
}
