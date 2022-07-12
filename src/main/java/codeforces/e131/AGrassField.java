package codeforces.e131;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AGrassField {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int cnt = 0;
    for (int i = 0; i < 4; i++) {
      int x = in.nextInt();
      cnt += x;
    }
    if (cnt == 0) {
      out.println(0);
    } else if (cnt == 4) {
      out.println(2);
    } else {
      out.println(1);
    }
  }
}
