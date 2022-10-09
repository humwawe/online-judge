package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;


public class BPipeline {
  long n;
  int k;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextLong();
    k = in.nextInt();

    int l = 1;
    int r = k + 1;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    if (l == 1) {
      out.println(-1);
    } else {
      out.println(k - l + 1);
    }
  }

  private boolean check(int mid) {
    return (long) (mid + k - 2) * (k - mid + 1) / 2 + 1 >= n;
  }
}
