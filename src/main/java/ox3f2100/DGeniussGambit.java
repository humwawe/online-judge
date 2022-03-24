package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DGeniussGambit {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int k = in.nextInt();
    int[] res1 = new int[a + b];
    int[] res2 = new int[a + b];
    for (int i = 0; i < b; i++) {
      res1[i] = 1;
      res2[i] = 1;
    }
    if (k == 0) {
      out.println("Yes");
      for (int j = 0; j < a + b; j++) {
        out.print(res1[j]);
      }
      out.println();
      for (int j = 0; j < a + b; j++) {
        out.print(res2[j]);
      }
      out.println();
      return;
    }
    for (int i = 1; i < b; i++) {
      if (res1[i] == 1 && i + k < a + b && res1[i + k] == 0) {
        res2[i + k] = 1;
        res2[i] = 0;
        out.println("Yes");
        for (int j = 0; j < a + b; j++) {
          out.print(res1[j]);
        }
        out.println();
        for (int j = 0; j < a + b; j++) {
          out.print(res2[j]);
        }
        out.println();
        return;
      }
    }
    out.println("No");
  }
}
