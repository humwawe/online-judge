package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DOmkarAndTheMeaningOfLife {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] b = new int[n];
    int[] a = new int[n];
    Arrays.fill(b, 1);
    for (int i = n; i >= 1; i--) {
      b[n - 1] = i;
      out.print("? ");
      out.println(b);
      out.flush();
      int x = in.nextInt();
      if (x != 0) {
        a[n - 1] = n - i + 1;
        break;
      }
    }
    if (a[n - 1] == 0) {
      a[n - 1] = n;
    }
    Arrays.fill(b, a[n - 1]);

    for (int i = 1; i <= n; i++) {
      if (i != a[n - 1]) {
        b[n - 1] = i;
        out.print("? ");
        out.println(b);
        out.flush();
        int x = in.nextInt();
        a[x - 1] = i;
      }
    }
    out.print("! ");
    out.println(a);
    out.flush();
  }
}
