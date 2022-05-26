package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DLittleGirlAndMaximumXOR {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long l = in.nextLong();
    long r = in.nextLong();

    long t = l ^ r;
    int len = 0;
    while (t > 0) {
      t >>= 1;
      len++;
    }
    out.println((1L << len) - 1);
  }
}
