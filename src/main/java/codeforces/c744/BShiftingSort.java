package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BShiftingSort {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = a.clone();
    Arrays.sort(b);
    List<String> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int j = 0;
      for (; j < n - i; j++) {
        if (a[j] == b[n - 1 - i]) {
          break;
        }
      }
      if (j + 1 == n - i) {
        continue;
      }
      res.add((j + 1) + " " + (n - i) + " 1");
      for (int k = j + 1; k < n - i; k++) {
        a[k - 1] = a[k];
      }
    }
    out.println(res.size());
    for (String r : res) {
      out.println(r);
    }
  }
}
