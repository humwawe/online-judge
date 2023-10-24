package lanqiao.b2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] x = new int[2];
    x[0] = in.nextInt();
    x[1] = in.nextInt();
    Arrays.sort(x);

    if (x[0] == 1) {
      out.println("No");
      return;
    }


    if (x[0] * x[1] % 6 == 0) {
      out.println("Yes");
      return;
    }

    out.println("No");

  }
}
