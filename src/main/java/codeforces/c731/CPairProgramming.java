package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPairProgramming {
  int k, n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    k = in.nextInt();
    n = in.nextInt();
    m = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }
    int[] res = new int[n + m];
    int i = 0, j = 0;
    int idx = 0;
    while (i < n && j < m) {
      if (b[i] == 0) {
        k++;
        res[idx++] = b[i];
        i++;
      } else if (b[j] == 0) {
        k++;
        res[idx++] = b[j];
        j++;
      } else if (b[i] > k && b[j] > k) {
        out.println(-1);
        return;
      } else if (b[i] <= k) {
        res[idx++] = b[i];
        i++;
      } else if (b[j] <= k) {
        res[idx++] = b[j];
        j++;
      }
    }
    while (i < n) {
      if (b[i] == 0) {
        res[idx++] = b[i];
        k++;
        i++;
      } else if (b[i] <= k) {
        res[idx++] = b[i];
        i++;

      } else if (b[i] > k) {
        out.println(-1);
        return;
      }
    }
    while (j < m) {
      if (b[j] == 0) {
        res[idx++] = b[j];
        k++;
        j++;
      } else if (b[j] <= k) {
        res[idx++] = b[j];
        j++;

      } else if (b[j] > k) {
        out.println(-1);
        return;
      }
    }
    for (int l : res) {
      out.print(l + " ");
    }
    out.println();
  }
}
