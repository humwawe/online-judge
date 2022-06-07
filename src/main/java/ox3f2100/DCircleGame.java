package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCircleGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long d = in.nextInt();
    long k = in.nextInt();
    long step = 0;
    while (true) {
      if ((step + 1) * k * (step + 1) * k * 2 <= d * d) {
        step++;
      } else {
        break;
      }
    }
    if ((step + 1) * k * (step + 1) * k + step * k * step * k <= d * d) {
      out.println("Ashish");
    } else {
      out.println("Utkarsh");
    }
  }
}
