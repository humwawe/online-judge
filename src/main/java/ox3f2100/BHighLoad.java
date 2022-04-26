package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BHighLoad {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int t = (n - 1) % k;
    if (t > 1) {
      out.println((n - 1 + k - 1) / k + (n - 1) / k + 1);
    } else {
      out.println((n - 1 + k - 1) / k + (n - 1) / k);
    }

    for (int i = 2; i <= k + 1; i++) {
      out.println(1, i);
    }
    for (int i = k + 2; i <= n; i++) {
      out.println(i, i - k);
    }
  }
}
