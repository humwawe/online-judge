package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DEhabTheXorcist {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long u = in.nextLong();
    long v = in.nextLong();
    if (u > v || u % 2 != v % 2) {
      out.println(-1);
      return;
    }
    if (u == v && u == 0) {
      out.println(0);
      return;
    }
    if (u == v) {
      out.println(1);
      out.println(u);
      return;
    }
    long t = (v - u) / 2;
    if ((u & t) == 0) {
      out.println(2);
      out.print(u + t);
    } else {
      out.println(3);
      out.print(u);
      out.print(" " + t);
    }
    out.println(" " + t);
  }
}
