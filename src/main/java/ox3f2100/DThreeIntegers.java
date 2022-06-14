package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DThreeIntegers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int max = 0;
    max = Math.max(max, a);
    max = Math.max(max, b);
    max = Math.max(max, c);
    int min = (int) 1e9;
    int[] res = new int[3];
    for (int i = 1; i <= max; i++) {
      for (int j = 1; i * j <= 2e4; j++) {
        for (int k = 1; i * j * k <= 2e4; k++) {
          int d = Math.abs(a - i) + Math.abs(i * j - b) + Math.abs(i * j * k - c);
          if (d < min) {
            min = d;
            res[0] = i;
            res[1] = i * j;
            res[2] = i * j * k;
          }
        }
      }
    }
    out.println(min);
    out.println(res);
  }
}
