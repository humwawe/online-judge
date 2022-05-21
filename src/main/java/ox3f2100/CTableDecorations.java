package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CTableDecorations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long[] a = new long[3];
    for (int i = 0; i < 3; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    if (a[2] >= (a[0] + a[1]) * 2) {
      out.println(a[0] + a[1]);
      return;
    }

    out.println((a[0] + a[1] + a[2]) / 3);
  }
}
