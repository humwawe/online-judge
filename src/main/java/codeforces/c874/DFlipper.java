package codeforces.c874;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DFlipper {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] pos = new int[n];
    int max = 0;
    int idx = n;
    for (int i = n - 1; i >= 0; i--) {
      pos[i] = idx;
      if (a[i] > max) {
        max = a[i];
        idx = i;
      }
    }
    int[] tmp = new int[n];

    for (int l = 0; l < n; l++) {
      int r = pos[l] - 1;
      int[] b = new int[n];
      int j = 0;
      for (int i = r + 1; i < n; i++) {
        b[j++] = a[i];
      }
      for (int i = r; i >= l; i--) {
        b[j++] = a[i];
      }
      for (int i = 0; i < l; i++) {
        b[j++] = a[i];
      }
      if (comp(b, tmp) > 0) {
        tmp = b;
      }

    }
    out.println(tmp);
  }

  private int comp(int[] b, int[] tmp) {
    for (int i = 0; i < b.length; i++) {
      if (b[i] == tmp[i]) {
        continue;
      }
      if (b[i] > tmp[i]) {
        return 1;
      }
      if (b[i] < tmp[i]) {
        return -1;
      }
    }
    return 0;
  }
}
