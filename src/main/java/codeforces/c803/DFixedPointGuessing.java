package codeforces.c803;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DFixedPointGuessing {
  InputReader in;
  OutputWriter out;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    int n = in.nextInt();
    int l = 1;
    int r = n;

    while (l < r) {
      int mid = l + r >> 1;
      int x = query(l, mid);
      if ((mid - l + 1) % 2 == 0) {
        if (x % 2 == 0) {
          l = mid + 1;
        } else {
          r = mid;
        }
      } else {
        if (x % 2 == 0) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
    }
    out.println("!", l);
    out.flush();
  }

  private int query(int l, int mid) {
    out.println("?", l, mid);
    out.flush();
    int res = 0;
    for (int i = 0; i < mid - l + 1; i++) {
      int x = in.nextInt();
      if (x >= l && x <= mid) {
        continue;
      }
      res++;
    }
    return res;
  }
}
