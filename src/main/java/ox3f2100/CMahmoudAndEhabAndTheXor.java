package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMahmoudAndEhabAndTheXor {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();

    if (n == 2 && x == 0) {
      out.println("NO");
      return;
    }
    out.println("YES");
    if (n == 1) {
      out.println(x);
      return;
    }
    if (n == 2) {
      out.println(0, x);
      return;
    }
    int sum = 0;
    for (int i = 1; i <= n - 3; i++) {
      sum ^= i;
      out.print(i, "");
    }
    int pw1 = 1 << 17;
    int pw2 = 1 << 18;
    if (sum == x) {
      out.println(pw1, pw2, pw1 + pw2);
    } else {
      out.println(0, sum ^ x ^ pw1, pw1);
    }
  }
}
