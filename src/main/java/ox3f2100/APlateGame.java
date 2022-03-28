package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APlateGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int r = in.nextInt();
    if (2 * r > a || 2 * r > b) {
      out.println("Second");
    } else {
      out.println("First");
    }
  }
}
