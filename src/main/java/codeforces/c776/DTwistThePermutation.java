package codeforces.c776;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTwistThePermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] res = new int[n];
    int[] tmp = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int need = i + 1;
      int op = 0;
      for (int j = 0; j <= i; j++) {
        if (a[j] == need) {
          op = (j + 1) % need;
          break;
        }
      }
      res[i] = op;
      for (int j = 0; j < op; j++) {
        tmp[j] = a[j];
      }
      int idx = 0;
      for (int j = op; j <= i; j++) {
        a[idx++] = a[j];
      }
      for (int j = 0; j < op; j++) {
        a[idx++] = tmp[j];
      }
    }
    out.println(res);
  }
}
