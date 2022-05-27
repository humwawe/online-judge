package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CMemoryAndDeEvolution {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int y = in.nextInt();
    int x = in.nextInt();
    int[] a = new int[]{x, x, x};
    int res = 0;
    while (a[0] < y) {
      a[0] = a[1] + a[2] - 1;
      Arrays.sort(a);
      res++;
    }
    out.println(res);
  }
}
