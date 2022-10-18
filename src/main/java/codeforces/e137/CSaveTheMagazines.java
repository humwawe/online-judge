package codeforces.e137;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CSaveTheMagazines {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') {
        int j = i;
        int t = a[i];
        sum += a[i];
        while (j + 1 < n && s.charAt(j + 1) == '1') {
          j++;
          t = Math.min(t, a[j]);
          sum += a[j];
        }
        sum -= t;
        i = j;
      } else {
        sum += a[i];
      }
    }
    out.println(sum);
  }
}
