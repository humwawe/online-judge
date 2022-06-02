package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ASearchingLocalMinimum {
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    a = new int[n + 2];
    a[0] = n + 1;
    a[n + 1] = n + 1;
    int l = 1;
    int r = n;
    while (l < r) {
      int mid = l + r >> 1;
      int x = query(out, in, mid);
      int y = query(out, in, mid + 1);
      if (x > y) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    out.println("!", l);
    out.flush();
  }

  private int query(OutputWriter out, InputReader in, int mid) {
    if (a[mid] != 0) {
      return a[mid];
    }

    out.println("?", mid);
    out.flush();
    a[mid] = in.nextInt();
    return a[mid];
  }
}
