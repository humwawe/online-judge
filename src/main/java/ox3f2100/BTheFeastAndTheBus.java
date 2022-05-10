package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BTheFeastAndTheBus {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[k + 1];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      a[x]++;
    }
    Arrays.sort(a, 1, k + 1);

    long res = (int) 1e15;
    int s = a[k];
    int e = a[k] + a[k - 1];
    for (int i = s; i <= e; i++) {
      int l = 1;
      int r = k;
      long cnt = 0;
      while (l <= r) {
        if (a[l] + a[r] <= i) {
          l++;
          r--;
        } else {
          r--;
        }
        cnt++;
      }
      res = Math.min(res, cnt * i);
    }
    out.println(res);
  }
}
