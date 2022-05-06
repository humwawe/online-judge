package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CBeautyPageant {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int cnt = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    for (int i = 0; i < n / 2; i++) {
      int t = a[i];
      a[i] = a[n - i - 1];
      a[n - i - 1] = t;
    }
    for (int len = 1; len <= n; len++) {
      for (int j = len - 1; j < n; j++) {
        out.print(len, "");
        for (int i = 0; i < len - 1; i++) {
          out.print(a[i], "");
        }
        out.println(a[j]);
        cnt++;
        if (cnt == k) {
          return;
        }
      }
    }
  }
}
