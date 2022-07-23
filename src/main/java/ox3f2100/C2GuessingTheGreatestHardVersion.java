package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class C2GuessingTheGreatestHardVersion {
  InputReader in;
  OutputWriter out;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    n = in.nextInt();
    int x = ask(1, n);
    int l = 1;
    int r = n;
    boolean f = false;
    if (x == 1) {
      l = 2;
      f = false;
    } else if (x == n) {
      r = n - 1;
      f = true;
    } else {
      int res = ask(1, x);
      if (res == x) {
        r = x - 1;
        f = true;
      } else {
        l = x + 1;
        f = false;
      }
    }
    if (f) {
      while (l < r) {
        int mid = l + r + 1 >> 1;
        int res = ask(mid, x);
        if (res == x) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
    } else {
      while (l < r) {
        int mid = l + r >> 1;
        int res = ask(mid, x);
        if (res == x) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
    }


    out.println("!", l);
    out.flush();


  }

  private int ask(int l, int r) {
    if (l > r) {
      int t = l;
      l = r;
      r = t;
    }
    out.println("?", l, r);
    out.flush();
    return in.nextInt();
  }
}
