package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPermutationCycle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    for (int x = 0; x * a <= n; x++) {
      if ((n - a * x) % b == 0) {
        int y = (n - a * x) / b;
        for (int i = 0; i < x; i++) {
          int start = a * i;
          for (int j = 1; j < a; j++) {
            out.print(start + j + 1, "");
          }
          out.print(start + 1, "");
        }

        for (int i = 0; i < y; i++) {
          int start = a * x + i * b;
          for (int j = 1; j < b; j++) {
            out.print(start + j + 1, "");
          }
          out.print(start + 1, "");
        }
        return;
      }
    }
    out.println(-1);
  }
}
