package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DDimaAndLisa {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (isprime(n)) {
      out.println(1);
      out.println(n);
    } else if (isprime(n - 2)) {
      out.println(2);
      out.println(2, n - 2);
    } else {
      out.println(3);
      n -= 3;
      for (int i = 3; i <= n; i++) {
        if (isprime(i) && isprime(n - i)) {
          out.println(3, i, n - i);
          return;
        }
      }
    }

  }

  boolean isprime(int x) {
    if (x == 1) {
      return false;
    }
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }
}
