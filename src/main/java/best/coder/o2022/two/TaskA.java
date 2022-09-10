package best.coder.o2022.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    long s = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      s += a[i];
    }
    out.println(s);
  }
}
