package code.jam.o2021.qualification;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Reversort {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int min = 1;
    int res = 0;
    for (int i = 0; i < n - 1; i++) {
      int j;
      for (j = i; j < n; j++) {
        if (a[j] == min) {
          break;
        }
      }
      res += j - i + 1;
      int l = i, r = j;
      while (l < r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
        l++;
        r--;
      }
      min++;
    }
    out.printf("Case #%d: %d\n", testNumber, res);
  }
}
