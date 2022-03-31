package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AShortProgram {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = 0;
    int b = 1024 - 1;
    for (int i = 0; i < n; i++) {
      char c = in.nextCharacter();
      int x = in.nextInt();
      if (c == '|') {
        a |= x;
        b |= x;
      }
      if (c == '&') {
        a &= x;
        b &= x;
      }
      if (c == '^') {
        a ^= x;
        b ^= x;
      }
    }
    out.println(3);
    out.println("| " + (a & b));
    out.println("& " + (a | b));
    out.println("^ " + (a & (1023 ^ b)));
  }
}
