package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CConnectThePoints {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] a = new int[3];
    int[] b = new int[3];
    int[] x = new int[3];
    int[] y = new int[3];
    for (int i = 0; i < 3; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
      x[i] = a[i];
      y[i] = b[i];
    }
    Arrays.sort(x);
    Arrays.sort(y);
    out.println(6);

    for (int i = 0; i < 3; i++) {
      out.println(a[i], b[i], a[i], y[1]);
      out.println(a[i], y[1], x[1], y[1]);
    }
  }
}
