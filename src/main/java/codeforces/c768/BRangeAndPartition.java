package codeforces.c768;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BRangeAndPartition {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = a[i];
    }
    Arrays.sort(b);
    int len = (n + k + 1) / 2;
    int range = (int) 1e8;
    int x = 0;
    int y = 0;
    for (int i = 0; i + len - 1 < n; i++) {
      int j = i + len - 1;
      if (b[j] - b[i] < range) {
        x = b[i];
        y = b[j];
        range = b[j] - b[i];
      }
    }
    out.println(x, y);
    int prev = 0;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] <= y && a[i] >= x) {
        cnt++;
      } else {
        cnt--;
      }
      if (cnt > 0 && --k > 0) {
        out.println(prev + 1, i + 1);
        prev = i + 1;
        cnt = 0;
      }
    }
    out.println(prev + 1, n);
  }
}
