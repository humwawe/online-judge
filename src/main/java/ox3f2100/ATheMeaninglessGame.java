package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ATheMeaninglessGame {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextInt();
    long b = in.nextInt();
    long pow = (long) (Math.cbrt(a * b));
    if (pow * pow * pow == a * b && a % pow == 0 && b % pow == 0) {
      out.println("Yes");
    } else {
      out.println("No");
    }

  }
}
