package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTersePrincess {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    if (a == n - 1 && n != 1) {
      out.println(-1);
      return;
    }
    int s = 1;
    out.print("1 ");
    for (int i = 0; i < b; i++) {
      out.print(s * 2, "");
      s *= 2;
    }
    for (int i = 0; i < n - a - b - 1; i++) {
      out.print(s, "");
    }
    for (int i = 0; i < a; i++) {
      out.print(++s, "");
    }
    out.println();
  }
}
