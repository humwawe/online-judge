package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTennisChampionship {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long a = 2;
    long b = 1;
    long res = 0;
    while (true) {
      if (a > n) {
        out.println(res);
        return;
      }
      res++;
      long c = a + b;
      b = a;
      a = c;
    }
  }
}
